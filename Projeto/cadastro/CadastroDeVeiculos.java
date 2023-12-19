package cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.menuPrincipal;
import veiculos.Barcos.Barco;
import veiculos.Carros.Carro;
import veiculos.Motos.Moto;
import veiculos.dominio.Veiculo;

public class CadastroDeVeiculos implements InterF {

    Scanner input = new Scanner(System.in);
    Cadastro cadastro = new Cadastro();

    protected List<Veiculo> LISTA_DE_VEICULOS_CADASTRADOS = new ArrayList<>(); //Essa é a lista principal com todos os veiculos cadastrados
    //Criei uma lista para cada tipo de veiculo
    protected List<Veiculo> LISTA_DE_CARROS_CADASTRADOS = new ArrayList<>(); 
    protected List<Veiculo> LISTA_DE_MOTOS_CADASTRADAS = new ArrayList<>();
    protected List<Veiculo> LISTA_DE_BARCOS_CADASTRADOS = new ArrayList<>();

    //Esse metodo adiciona o veiculo tanto na lista principal como na lista referente ao seu tipo
    public void addVeiculo(Veiculo veiculo) {
        if (getVeiculoID(veiculo.getID()) != 1) { //assim como na adição de novos clientes eu tambem verifico se o veiculo ja esta cadastrado no sistema
            LISTA_DE_VEICULOS_CADASTRADOS.add(veiculo);

            //Usei o instaceof para verificar o tipo
            if (veiculo instanceof Carro) {
                LISTA_DE_CARROS_CADASTRADOS.add(veiculo);
            } else if (veiculo instanceof Moto) {
                LISTA_DE_MOTOS_CADASTRADAS.add(veiculo);
            } else if (veiculo instanceof Barco) {
                LISTA_DE_BARCOS_CADASTRADOS.add(veiculo);
            }

            veiculo.setCad(true);//Aqui eu passo o cadastro do veiculo para verdadeiro
            System.out.print("\u001b[32mVeiculo cadastrado com sucesso\u001b[0m\n");
        } else {
            System.out.print("\u001b[31mVeiculo ja cadastrado no sistema\u001b[0m\n");
        }
    }

    //retorna um veiulo
    public Veiculo getVeiculo(int id) {
        for (int i = 0; i < LISTA_DE_VEICULOS_CADASTRADOS.size(); i++) {
            if (LISTA_DE_VEICULOS_CADASTRADOS.get(i).getID() == id) {
                return LISTA_DE_VEICULOS_CADASTRADOS.get(i);
            }
        }
        return null;
    }

    //retorna o 1 se o veiculo estiver na lista e -1 se não estiver
    public int getVeiculoID(int id) {
        for (int i = 0; i < LISTA_DE_VEICULOS_CADASTRADOS.size(); i++) {
            if (LISTA_DE_VEICULOS_CADASTRADOS.get(i).getID() == id) {
                return 1;
            }
        }
        return -1;
    }

    //Retorna o indice de um veiculo da lista
    public int retornaIndiceVeiculoCadastrado(int id) {
        for (int i = 0; i < LISTA_DE_VEICULOS_CADASTRADOS.size(); i++) {
            if (LISTA_DE_VEICULOS_CADASTRADOS.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    //Retorna a lista de veiculos
    public List<Veiculo> getListVeiculos() {
        return LISTA_DE_VEICULOS_CADASTRADOS;
    }

    //Esse metodo vai chamar o metodo realizarCadastroCarro() da classe de cadatro
    @Override
    public void realizarUmCadastro() {
        System.out.print("\033c");
        System.out.println("--------------------< BOAS VINDAS AO CADASTRO DE NOVOS VEICULOS >--------------------");
        System.out.println("[1] Iniciar um novo cadastro");
        System.out.println("[0] Voltar");

        int op = 0;
        boolean opValido = false;

        do {
            try {
                System.out.print("$ ");
                op = input.nextInt();
                if (op >= 0 && op <= 1) {
                    opValido = true;

                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                input.nextLine();
            }
        } while (!opValido);
        input.nextLine();

        if (op == 1) {
            System.out.print("\033c");
            System.out.print("Que tipo de veiculo deseja cadastrar?\n"); //aqui eu peço o tipo de veiculo
            System.out.print("[1] Carro     [2] Moto      [3] Barco   [0] Voltar\n");

            int mc = 0;
            boolean mcvalido = false;
            do {
                try {
                    System.out.print("$ ");
                    mc = input.nextInt();
                    if (mc >= 0 && mc <= 3) {
                        mcvalido = true;
                    } else {
                        System.out.println("Valor invalido");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada invalida");
                    input.nextLine();
                }
            } while (!mcvalido);
            input.nextLine();

            if (mc == 0) {
                System.out.print("\033c"); //caso de saida
                menuPrincipal.INSTACE.menuinicialFuncionario();
            
            //A partir da decisão do tipo do veiculo eu passo como parametro do construtor o metodo realizarCadastroCarro()
            } else if (mc == 1) {

                Veiculo carro = (cadastro.realizarCadastroCarro());
                addVeiculo(carro);

                menuPrincipal.INSTACE.menuinicialFuncionario();

            } else if (mc == 2) {

                Veiculo moto = (cadastro.realizarCadastroMoto());
                addVeiculo(moto);

                menuPrincipal.INSTACE.menuinicialFuncionario();
            } else if (mc == 3) {
                Veiculo barco = (cadastro.realizarCadastroBarco());
                addVeiculo(barco);

                menuPrincipal.INSTACE.menuinicialFuncionario();
            }

        } else {
            System.out.print("\033c");
            menuPrincipal.INSTACE.menuinicialFuncionario();
        }

    }

    //Metodo para remover o veiculo
    public void rmVeiculo() {
        System.out.print("\033c");
        if (!LISTA_DE_VEICULOS_CADASTRADOS.isEmpty()) {
            for (Veiculo veiculo : LISTA_DE_VEICULOS_CADASTRADOS) {
                System.out.println(veiculo + "\n");
            }
            System.out.println("Digite o Id do veiculo que deseja remover");

            int ev = 0;
            boolean evValido = false;

            do {
                try {
                    System.out.print("$ ");
                    ev = input.nextInt();
                    if (getVeiculoID(ev) != -1) {
                        evValido = true;
                    } else {
                        System.out.println("Invalido");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }
            } while (!evValido);
            input.nextLine();

            LISTA_DE_VEICULOS_CADASTRADOS.remove(getVeiculo(ev));

            System.out.print("\033c");
            System.out.print("Veiculo removido\n");
            menuPrincipal.INSTACE.menuinicialFuncionario();

        } else {
            System.out.print("\033c");
            System.out.print("Erro, você ainda não cadastrou nenhum veiculo\n");
            menuPrincipal.INSTACE.menuinicialFuncionario();
        }
    }

    //metodo para listar os veiculos
    @Override
    public void listar() {
        if (!LISTA_DE_VEICULOS_CADASTRADOS.isEmpty()) {
            System.out
                    .println("----------------------LISTA DE VEICULOS CADASTRADOS----------------------\n");
            for (Veiculo veiculo : LISTA_DE_VEICULOS_CADASTRADOS) {
                System.out.println(veiculo + "\n");
            }
            int escolha = 0;
            boolean escolhaValida = false;


            //Aqui eu criei um filtro para listar tipos de veiculos expecificos
            while (escolha != 4) { // Condição de saida
                System.out.print("\u001b[37m[1]\u001b[32m Listar somente Carros   \u001b[37m[2]\u001b[32m  Listar somente Motos   \u001b[37m[3]\u001b[32m Listar somente Barcos   \u001b[37m[4]\u001b[32m Voltar \n");

                do {
                    try {
                        System.out.print("$ ");
                        escolha = input.nextInt();
                        if (escolha >= 1 && escolha <= 4) {
                            escolhaValida = true;
                        } else {
                            System.out.println("Opção invalida");
                        }
                    } catch (Exception e) {
                        System.out.println("Valor invalido");
                        input.nextLine();
                    }
                } while (!escolhaValida);
                input.nextLine();

                System.out.print("\033c");

                if (escolha == 1) {
                    listarCarros();
                }
                else if(escolha == 2){
                    listarMotos();
                }
                else if(escolha == 3){
                    listarBarcos();
                }
            }
            menuPrincipal.INSTACE.menuinicialFuncionario();

        //Caso ainda não tenha veiculos cadastrados no sistema
        } else {
            System.out.println("----------------------AINDA NÃO EXISTEM VEICULOS CADASTRADOS----------------------");
            System.out.println("[1] Realizar um cadastro");
            System.out.println("[2] Voltar\n");

            System.out.print("$ ");
            int op = 0;
            boolean entradavalida = false;

            do {
                try {
                    op = input.nextInt();
                    if (op > 0 && op <= 2) {
                        entradavalida = true;
                    } else {
                        System.out.println("Opção invalida");
                        entradavalida = false;
                    }
                } catch (Exception e) {
                    System.out.println("Entrada invalida!");
                    input.nextLine();
                }
            } while (!entradavalida);
            input.nextLine();

            if (op == 1) {
                realizarUmCadastro();

            } else if (op == 2) {
                System.out.print("\033c");
                menuPrincipal.INSTACE.menuinicialFuncionario();
            }
        }
    }

    //Metodos de listagem separados
    public void listarCarros() {
        System.out.print("\033c");
        if(!LISTA_DE_CARROS_CADASTRADOS.isEmpty()){
            System.out.println("----------------------LISTA DE CARROS CADASTRADOS----------------------\n");
            for (Veiculo carro : LISTA_DE_CARROS_CADASTRADOS) {
                System.out.println(carro + "\n");
            }
        }
        else{
            System.out.println("Ainda não foi cadastrado nenhum Carro");
        }
        
    }
    public void listarMotos() {
        System.out.print("\033c");
        if(!LISTA_DE_MOTOS_CADASTRADAS.isEmpty()){
            System.out.println("----------------------LISTA DE MOTOS CADASTRADOS----------------------\n");
            for (Veiculo moto : LISTA_DE_MOTOS_CADASTRADAS) {
            System.out.println(moto + "\n");
            }
        }
        else{
            System.out.println("Ainda não foi cadastrada nenhuma Moto");
        }
        
    }
    public void listarBarcos() {
        System.out.print("\033c");
        if(!LISTA_DE_BARCOS_CADASTRADOS.isEmpty()){
            System.out.println("----------------------LISTA DE BARCOS CADASTRADOS----------------------\n");
            for (Veiculo barco : LISTA_DE_BARCOS_CADASTRADOS) {
                System.out.println(barco + "\n");
            }
        }
        else{
            System.out.println("Ainda não foi cadastrada nenhum Barco");
        }

    }

}
