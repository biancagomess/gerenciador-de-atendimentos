import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarAtendimentos {
    private static final ArrayList<Mesa> BD_Mesas = new ArrayList<Mesa>();
    private static final ArrayList<Garcom> BD_Garcons = new ArrayList<Garcom>();

    public static void main(String[] args) {
        Scanner scannerDados = new Scanner(System.in);
        boolean programaExecutando = true;

        while (programaExecutando) {
            mostraMenu();
            int opcaoMenu = scannerDados.nextInt();
            String escolha;

            switch (opcaoMenu) {
                //Cadastra mesa
                case 1 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Cadastrando Mesa ~~~~~~~~~~~~~~~~~~~~");
                        cadastrarMesa();
                        System.out.println("Deseja cadastar mais uma mesa? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Remove mesa
                case 2 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~ Removendo Mesa ~~~~~~~~~~~~~~~~~~~~~~~~");
                        removerMesa();
                        System.out.println("Deseja remover outra mesa? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Cadastra Garçom
                case 3 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~ Cadastrando Garçom ~~~~~~~~~~~~~~~~~~~~~~");
                        cadastrarGarcom();
                        System.out.println("\nDeseja cadastar outro garçom? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Remove Garçom
                case 4 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~ Removendo Garçom ~~~~~~~~~~~~~~~~~~~~~~~~");
                        removerGarcom();
                        System.out.println("\n Deseja remover outro garçom? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Busca mesa pelo número
                case 5 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~ Buscando mesa pelo número ~~~~~~~~~~~~~~~~~~");
                        buscarMesaPorNumero();
                        System.out.println("\nDeseja buscar outra mesa? \nS = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Busca mesa pela capacidade de clientes
                case 6 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~ Buscando mesa pela capacidade de clientes ~~~~~~~~~~");
                        buscarMesaPorCapacidade();
                        System.out.println("\nDeseja fazer uma nova busca? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }
                case 7 -> {//Imprime relatório completo de mesas
                    System.out.println("\n~~~~~~~~~~~~~~~~ Relatório completo de todas as mesas ~~~~~~~~~~~~");
                    ArrayList<Mesa> relatorioMesas = imprimirRelatorioMesas();
                    for (Mesa listaMesa : relatorioMesas) {
                        if (listaMesa == null) {
                            System.out.println("Não há mesas cadastradas!");
                        } else {
                            imprimeMesa(listaMesa);
                        }
                    }
                    break;
                }

                //Imprime mesas ocupadas
                case 8 -> {
                    System.out.println("\n~~~~~~~~~~ Relatório mesas ocupadas com garçom responsável ~~~~~~~");
                    mostraMesasOcupadas();
                    break;
                }

                //Imprime relatório com as mesas livres
                case 9 -> {
                    System.out.println("\n~~~~~~~~~~ Relatório mesas livres com garçom responsável ~~~~~~~~~");
                    mostraMesasLivres();
                    break;
                }

                //Busca garçom pelo email
                case 10 -> {
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~ Buscando Garçom pelo email ~~~~~~~~~~~~~~~~~~~~~");
                        buscarGarcomPorEmail();
                        System.out.println("\nDeseja pesquisar novamente? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();

                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Verifica o nome do garçom de uma determinada mesa
                case 11 -> {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Verificar garçom em atendimento de uma mesa ~~~~~~~");
                    do {
                        try {
                            boolean mEncontrada = false;
                            System.out.println("Qual número de mesa você deseja consultar ? ");
                            Integer numMesaConsult = scannerDados.nextInt();
                            for (Mesa mesa : BD_Mesas) {
                                if (numMesaConsult.equals(mesa.getNumeroMesa())) {
                                    for (Garcom garcons : BD_Garcons) {
                                        System.out.println("Garçom responsável: " + garcons.getNome());
                                    }
                                    mEncontrada = true;
                                    break;
                                }
                            }
                            if (!mEncontrada) {
                                System.out.println("Mesa não encontrada!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao pesquisar!");
                        }
                        System.out.println("\nDeseja pesquisar novamente? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();
                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;
                }

                //Vincula atendimento de garçom a uma mesa
                case 12 -> {
                    do {
                        boolean mesaEncontrada = false;
                        boolean garcomEncontrado = false;
                        int indexMesa = -1;
                        try {
                            do {
                                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Vincular garçom a uma mesa ~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\nDigite o número da mesa que quer atribuir ao garçom: ");
                                Integer codMesa = scannerDados.nextInt();

                                for (int i = 0; i < BD_Mesas.size(); i++) {
                                    if (codMesa.equals(BD_Mesas.get(i).getNumeroMesa())) {
                                        indexMesa = i;
                                        mesaEncontrada = true;
                                        break;
                                    }
                                    mesaEncontrada = false;
                                }

                                if (!mesaEncontrada) {
                                    System.out.println("Mesa não encontrada!\n ");
                                    break;
                                }

                            } while (!mesaEncontrada);

                            do {
                                System.out.println("Informe o código do garçom responsável por esta mesa: ");
                                Integer codGarcomResponsavel = scannerDados.nextInt();

                                for (Garcom garcom : BD_Garcons) {
                                    if (codGarcomResponsavel.equals(garcom.getIdGarcom())) {
                                        garcomEncontrado = true;
                                        BD_Mesas.get(indexMesa).setNomeGarcom(garcom.getNome());
                                        break;
                                    }
                                    garcomEncontrado = false;
                                }
                                if (!garcomEncontrado) {
                                    System.out.println("Garçom não encontrado!\n ");
                                    break;
                                }
                            } while (!garcomEncontrado);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao vincular atendimento! Verifique se há mesas ou garçons cadastrados.");
                        }
                        System.out.println("\nDeseja vincular mais uma mesa? \n S = Sim ou N = Não ?");
                        escolha = scannerDados.next();

                    } while ("S".equalsIgnoreCase(escolha)||"Sim".equalsIgnoreCase(escolha));
                    break;

                }

                //Encerra o programa
                case 0 -> {
                    System.out.println("\nO sistema será encerrado....! \nVolte sempre!");
                    programaExecutando = false;
                    break;
                }
                default -> {
                    System.out.println("\nOpção inválida. \nEscolha outra opção. ");
                    break;
                }
            }
        }
        scannerDados.close();
    }

    private static void imprimeMesa(Mesa listaMesa) {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("\tNúmero da mesa: " + listaMesa.getNumeroMesa());
        System.out.println("\tSituação da mesa: " + listaMesa.getSituacao());
        System.out.println("\tCapacidade máxima da mesa: " + listaMesa.getCapacityMaxClientes());
        System.out.printf("\tGarçom responsável: " + listaMesa.getNomeGarcom());
        System.out.println("\n-----------------------------------------------------------------");
    }

    private static void imprimeGarcom(Garcom garcom) {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("Id-Garçom: " + garcom.getIdGarcom());
        System.out.println("\tNome Garçom: " + garcom.getNome());
        System.out.println("\tCPF: " + garcom.getCpf());
        System.out.println("\tData Nascimento: " + garcom.getDataNascimento());
        System.out.println("\tE-mail: " + garcom.getEmail());
        System.out.println("\tTelefone: " + garcom.getTelefone());
        System.out.println("\tSexo: " + garcom.getSexo());
        System.out.println("\tSalário Fixo: " + garcom.getSalarioFixo());
        System.out.println("-----------------------------------------------------------------");
    }

    private static void mostraMesasOcupadas() {
        ArrayList<Mesa> listMesas = imprimirRelatorioMesas();
        boolean mesaOcupada = false;
        for (Mesa listMesaOcupada : listMesas) {
            if (listMesaOcupada.getSituacao().equals("Ocupada")) {
                imprimeMesa(listMesaOcupada);
                mesaOcupada = true;
            }
        }
        if (!mesaOcupada) {
            System.out.println("Não há mesas ocupadas! ");
        }
    }

    private static void mostraMesasLivres() {
        ArrayList<Mesa> listMesas = imprimirRelatorioMesas();
        boolean mesaLivre = false;
        for (Mesa listMesaOcupada : listMesas) {
            if (listMesaOcupada.getSituacao().equals("Livre")) {
                imprimeMesa(listMesaOcupada);
                mesaLivre = true;
            }
        }
        if (!mesaLivre) {
            System.out.println("Não há mesas Livres! ");
        }
    }

    private static ArrayList<Mesa> imprimirRelatorioMesas() {
        return BD_Mesas;

    }

    private static void buscarGarcomPorEmail() {
        Scanner leEmailGarcom = new Scanner(System.in);
        System.out.println("Qual o email você deseja consultar ? ");
        String emailGarcon = leEmailGarcom.next();
        try {
            for (Garcom garcons : BD_Garcons) {
                if (emailGarcon.equals(garcons.getEmail())) {
                    imprimeGarcom(garcons);

                } else {
                    System.out.println("Erro ao buscar garçom! Tente novamente.\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao fazer está busca!");
        }
    }

    private static void buscarMesaPorCapacidade() {
        Scanner lerDadosMesa = new Scanner(System.in);
        try {
            System.out.println("Informe a capacidade de cliente na mesa: ");
            Integer capacidadeMesaConsult = lerDadosMesa.nextInt();
            boolean encontrada = false;
            for (Mesa mesa : BD_Mesas) {
                if (capacidadeMesaConsult.equals(mesa.getCapacityMaxClientes())) {
                    imprimeMesa(mesa);
                    encontrada = true;
                }
            }
            if (!encontrada) {
                System.out.println("Não existe mesa com esta capacidade de clientes!\n ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nDeseja buscar outra mesa? \nS = Sim ou N = Não ?");
        }

    }

    private static void buscarMesaPorNumero() {
        Scanner lerDadosMesa = new Scanner(System.in);
        try {
            System.out.println("Qual número de mesa você deseja consultar ? ");
            Integer numMesaConsult = lerDadosMesa.nextInt();
            boolean mesaEncontrada = false;
            for (Mesa mesa : BD_Mesas) {
                if (numMesaConsult.equals(mesa.getNumeroMesa())) {
                    imprimeMesa(mesa);
                    mesaEncontrada = true;
                }
            }
            if (!mesaEncontrada) {
                System.out.println("Mesa não encontrada!\n ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar essa mesa! Tente novamente.");
        }

    }

    private static void removerGarcom() {
        Scanner lerDadosRemover = new Scanner(System.in);
        System.out.println("Informe o número do Garçom que deseja remover: ");
        Integer numGarcomRemove = lerDadosRemover.nextInt();
        try {
            if (BD_Garcons.size() == 0) {
                System.out.println("\nGarçom não encontrado!");
            } else {
                boolean garcomRemovido = false;
                for (int i = 0; i < BD_Garcons.size(); i++) {
                    Garcom garcomCadastrado = BD_Garcons.get(i);
                    if (numGarcomRemove.equals(garcomCadastrado.getIdGarcom())) {
                        imprimeGarcom(garcomCadastrado);
                        BD_Garcons.remove(i);
                        System.out.printf("Garçom %s removido com sucesso!", garcomCadastrado.getNome());
                        garcomRemovido = true;
                        break;
                    }
                }
                if (!garcomRemovido) {
                    System.out.println("Garçom não encontrado!\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao remover garçom.");
        }

    }

    private static void cadastrarGarcom() {
        Scanner lerDadosGarcom = new Scanner(System.in);
        try {
            String nomeGarcom = "";
            Integer idGarcon;
            boolean garcomEncontrado = false;
            do {
                System.out.println("Informe o código do garçom:");
                idGarcon = lerDadosGarcom.nextInt();
                if (BD_Garcons.size() > 0) {
                    for (Garcom garcom : BD_Garcons) {
                        if (idGarcon.equals(garcom.getIdGarcom())) {
                            garcomEncontrado = true;
                            break;
                        }
                        garcomEncontrado = false;
                    }

                    if (garcomEncontrado) System.out.println("Já existe um garçom com este código!\n ");
                } else {
                    garcomEncontrado = false;
                }
            } while (garcomEncontrado);

            do {
                System.out.println("Informe o nome do garçom: ");
                nomeGarcom = lerDadosGarcom.next();
                if (BD_Garcons.size() > 0) {
                    for (Garcom garcom : BD_Garcons) {
                        if (nomeGarcom.equals(garcom.getNome())) {
                            garcomEncontrado = true;
                            break;
                        }
                        garcomEncontrado = false;
                    }

                    if (garcomEncontrado) System.out.println("Já existe um garçom com este nome!\n ");
                } else {
                    garcomEncontrado = false;
                }
            } while (garcomEncontrado);

            System.out.println("Informe o cpf do garçom: ");
            String cpfGarcom = lerDadosGarcom.next();

            System.out.println("Informe a data de nascimento do garçom(dd/MM/YYYY):");
            String dataNascimentoGarcom = lerDadosGarcom.next();

            System.out.println("Informe email do garçom:");
            String emailGarcom = lerDadosGarcom.next();

            System.out.println("Informe telefone do garçom:(00) 9-0000-0000");
            Integer telefoneGarcom = lerDadosGarcom.nextInt();

            System.out.println("Informe o sexo do garçom: (F ou M)");
            String sexo = lerDadosGarcom.next();

            System.out.println("Informe o salário fixo do Garçom: ");
            Double salarioFixo = lerDadosGarcom.nextDouble();

            Garcom novoGarcom = new Garcom(idGarcon, nomeGarcom, cpfGarcom, dataNascimentoGarcom, emailGarcom, telefoneGarcom, sexo, salarioFixo);
            BD_Garcons.add(novoGarcom);
            System.out.printf("\t\tGarçom %s cadastrado com sucesso!", novoGarcom.getNome());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar garçom!");
        }

    }

    private static void removerMesa() {
        Scanner lerDadosRemover = new Scanner(System.in);
        System.out.println("Informe o número da mesa que deseja remover: ");
        Integer numMesaRemove = lerDadosRemover.nextInt();
        try {
            if (BD_Mesas.size() == 0) {
                System.out.println("\nMesa não encontrada!\n");
            } else {
                boolean mesaRemovida = false;
                for (int i = 0; i < BD_Mesas.size(); i++) {
                    Mesa mesaCadastrada = BD_Mesas.get(i);

                    if (numMesaRemove.equals(mesaCadastrada.getNumeroMesa())) {
                        imprimeMesa(mesaCadastrada);
                        BD_Mesas.remove(i);
                        System.out.println("Mesa renovida com sucesso!\n");
                        mesaRemovida = true;

                        break;
                    }
                }
                if (!mesaRemovida) {
                    System.out.println("Mesa não encontrada!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao remover mesa. Tente novamente!");
        }
    }

    private static void cadastrarMesa() {
        Scanner lerDadosMesa = new Scanner(System.in);
        boolean cadastrada = false;
        System.out.println("Informe o número da mesa: ");
        int numMesa = lerDadosMesa.nextInt();

        for (Mesa mesas : BD_Mesas) {
            if (numMesa == mesas.getNumeroMesa()) {
                System.out.println("Mesa já cadastrada!\n");
                cadastrada = true;
                break;
            }
        }
        if (!cadastrada) {
            String situacaoMesa = "";
            do {
                System.out.println("Informe a situação da mesa: \n\t[0] - Livre\n\t[1] - Ocupada\n\t[2] - Reservada");
                String leStatusMesa = lerDadosMesa.next();
                switch (leStatusMesa) {
                    case "0" -> situacaoMesa = "Livre";
                    case "1" -> situacaoMesa = "Ocupada";
                    case "2" -> situacaoMesa = "Reservada";
                    default -> System.out.println("Informe uma situação válida!\n ");
                }
            } while (situacaoMesa.equals(""));


            System.out.println("Informe a capacidade máxima de clientes desta mesa:");
            int capacityClientes = lerDadosMesa.nextInt();

            Mesa novaMesa = new Mesa(numMesa, situacaoMesa, capacityClientes, null, "Não há garçom responsável no momento.");

            BD_Mesas.add(novaMesa);
        }
    }

    public static void mostraMenu() {
        System.out.println("");
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("|                   OPÇÕES DE MENU                               |");
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("| [01] - Cadastrar mesa.                                         |");
        System.out.println("| [02] - Remover mesa.                                           |");
        System.out.println("| [03] - Cadastrar garçom.                                       |");
        System.out.println("| [04] - Remover garçom.                                         |");
        System.out.println("| [05] - Buscar mesa pelo número.                                |");
        System.out.println("| [06] - Buscar mesa pela capacidade de clientes.                |");
        System.out.println("| [07] - Relatório completo de todas as mesas.                   |");
        System.out.println("| [08] - Relatório de mesas ocupadas com o garçom responsável.   |");
        System.out.println("| [09] - Relatório de mesas livres com o garçom responsável.     |");
        System.out.println("| [10] - Buscar garçom pelo e-mail.                              |");
        System.out.println("| [11] - Verificar o nome do garçom atendendo uma mesa.          |");
        System.out.println("| [12] - Vincular garçom a uma mesa.                             |");
        System.out.println("| [00] - Sair.                                                   |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("--> Digite o número da sua opção: ");
    }

}