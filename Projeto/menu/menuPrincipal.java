package menu;

import java.util.Scanner;
import cadastro.CadastroDeClientes;
import cadastro.CadastroDeVeiculos;
import usuario.Cliente;
import veiculos.dominio.Veiculo;

/*Usei o padrão de projeto singleton para que eu possa instanciar essa classe somente uma vez
* Chamarei essa classe varias vezes ao longo da execução do programa por isso optei com criar uma
* unica instancia da mesma
*/

public class menuPrincipal {

    Scanner input = new Scanner(System.in);
    static CadastroDeClientes cadastroCliente = new CadastroDeClientes(); //Criei um objeto de CadastroDeClintes para usar seus metodos 
    static CadastroDeVeiculos cadastroVeiculo = new CadastroDeVeiculos(); //Criei um objeto de CadastroDeVeiculos para usar seus metodos 

    public static final menuPrincipal INSTACE = new menuPrincipal(); //Criando a instancia unica da classe

    private menuPrincipal() { //Passei o construtor para privado pois ele não sera instanciado em nenhum outro lugar
    }

    // Tela inicial do programa, vai imprimir o banner e pedir a entrada de iniciar
    // ou sair do sistema
    public void telaInicial() {
        banner info = new banner();
        info.cons();
        info.info();

        System.out.println("\u001b[37m[1]\u001b[32m Entrar");
        System.out.println("\u001b[37m[2]\u001b[32m Sair");
        System.out.print("$ ");
        int op = 0;
        boolean entradavalida = false;

        do {
            try {
                op = input.nextInt();
                if (op > 0 && op <= 3) {
                    entradavalida = true;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                entradavalida = false;
                input.nextLine();
            }
        } while (!entradavalida);
        input.nextLine(); // Limpa a nova linha não consumida.

        if (op == 1) {
            System.out.print("\033c");
            menuinicialFuncionario();
        } else if (op == 2) {
            System.exit(0);
        }
    }

    //Esse é o metodo principal de todo o programa pois daqui seram chamadas todas as funcionalidades do mesmo
    public void menuinicialFuncionario() {
        //Mostrando as opçoes
        System.out.print("-----------------------------------------------------------------------------------------------------------------------\n");
        System.out.print(
                "\u001b[37m[1]\u001b[32m Cadastrar um novo cliente  \u001b[37m[4]\u001b[32m Listar Veiculos  \u001b[37m[7]\u001b[32m Vender  \u001b[37m[10]\u001b[32m Listar Carros   \u001b[37m[13]\u001b[32m Remover veiculo de um cliente\n");
        System.out.print(
                "\u001b[37m[2]\u001b[32m Cadastrar um novo veiculo  \u001b[37m[5]\u001b[32m Remover Cliente  \u001b[37m[8]\u001b[32m Trocar  \u001b[37m[11]\u001b[32m Listar Motos    \u001b[37m[14]\u001b[32m Sair\n");
        System.out.print(
                "\u001b[37m[3]\u001b[32m Listar Clientes            \u001b[37m[6]\u001b[32m Remover Veiculo  \u001b[37m[9]\u001b[32m Voltar  \u001b[37m[12]\u001b[32m Listar Barcos\n");
        System.out.print("$ ");
        int op = 0;

        boolean entradavalida = false;
        do {
            try {
                op = input.nextInt();
                if (op > 0 && op <= 14) {
                    entradavalida = true;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                entradavalida = false;
                input.nextLine();
            }
        } while (!entradavalida);
        input.nextLine(); // Limpa a nova linha não consumida.

        if (op == 1) { //Realizar o cadastro de um cliente
            cadastroCliente.realizarUmCadastro();
        } else if (op == 2) {//Realizar o cadastro de um veiculo
            cadastroVeiculo.realizarUmCadastro();
        } else if (op == 3) {//Listar os clintes
            System.out.print("\033c");
            cadastroCliente.listar();
            menuinicialFuncionario();
        } else if (op == 4) {//Listar os veiculos
            System.out.print("\033c");
            cadastroVeiculo.listar();
            menuinicialFuncionario();
        } else if (op == 5) {//Remover um cliente
            cadastroCliente.rmCliente();
        } else if (op == 6) {//Remover um veiculo
            cadastroVeiculo.rmVeiculo();
        } else if (op == 7) { //Vender um veiculo
            vender();
        } else if (op == 8) {//Trocar um veiculo
            trocar();
        } else if (op == 9) {//voltar para a tela inicial
            telaInicial();
        }else if(op == 10){//Listar somente os carros
            cadastroVeiculo.listarCarros();
            menuinicialFuncionario();
        }else if(op == 11){//Listar somente os Motos
            cadastroVeiculo.listarMotos();
            menuinicialFuncionario();
        }else if(op == 12){//Listar somente os Barcos
            cadastroVeiculo.listarBarcos();
            menuinicialFuncionario();  
        } else if (op == 13) { //Remover Veiculo de um clinte
            removerVeiculoCliente();
        }else if(op == 14){//Sair do programa
            System.exit(0);
        }
        
    }

    //Metodo para realizar a venda de um veiculo
    public void vender() {
        if (!cadastroVeiculo.getListVeiculos().isEmpty() && !cadastroCliente.getListClientes().isEmpty()) { //Verifico se existem veiculos cadastrados e se exite clientes cadastrados
            //Imprimindo a Lista de veiculos
            System.out.print("\033c");
            System.out.println("Selecione o ID do veiculo a ser vendido\n");
            System.out.println("----------------------LISTA DE VEICULOS CADASTRADOS----------------------\n");
                for (Veiculo veiculo : cadastroVeiculo.getListVeiculos()) { /*Fiz a impressão sem usar o metodo listar() que criei na classe CadastroDeVeiculos, pois devido o filtro o metodo precisa
                                                                            de uma entrada que não é necessaria aqui*/
                    System.out.println(veiculo + "\n");
                }

            int eV = 0;
            boolean valorValidoV = false;
            do {
                try {
                    System.out.print("$ ");
                    eV = input.nextInt();
                    if (cadastroVeiculo.getVeiculo(eV) != null) { //Verificando se o veiculo existe
                        valorValidoV = true;
                    } else {
                        System.out.println("fail: Opção inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("fail: Entrada inválida.");
                    valorValidoV = false;
                    input.nextLine();
                }
            } while (!valorValidoV);
            input.nextLine();

            Veiculo veiculo = cadastroVeiculo.getVeiculo(eV); //Guardando o veiculo selecionado

            //Imprimindo a lista de clientes
            System.out.print("\033c");
            System.out.println("Selecione o ID do Cliente comprador\n");
            cadastroCliente.listar(); //Aqui usei o metodo proprio de listar

            int eC = 0;
            boolean valorValidoC = false;
            do {
                try {
                    System.out.print("$ ");
                    eC = input.nextInt();
                    if (cadastroCliente.getCliente(eC) != null) {
                        valorValidoC = true;
                    } else {
                        System.out.println("fail: Opção inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("fail: Entrada inválida.");
                    valorValidoC = false;
                    input.nextLine();
                }
            } while (!valorValidoC);
            input.nextLine();

            cadastroCliente.getCliente(eC).receberVeiculo(veiculo); //Usando o metodo receberVeiculo() para adicionar o veiculo a lista de veiculos comprados do clintes
            System.out.print("\033c");
            menuinicialFuncionario();

        }else if(cadastroVeiculo.getListVeiculos().isEmpty()) {
            System.out.print("\033c");
            System.out.println("Erro, você ainda não cadastrou nenhum veiculo");
            menuinicialFuncionario();
        }
        else if(cadastroCliente.getListClientes().isEmpty()){
            System.out.print("\033c");
            System.out.println("Erro, você ainda não cadastrou nenhum Cliente");
            menuinicialFuncionario();
        }
    }

    public void trocar() {
        if (!cadastroCliente.getListClientes().isEmpty() && !cadastroVeiculo.getListVeiculos().isEmpty() ) {//Verifico se existem veiculos cadastrados e se exite clientes cadastrados

            if (cadastroVeiculo.getListVeiculos().size() < 2) {//se não houver mais que 1 veiculo na lista não sera possivel a troca
            System.out.print("\033c");
            System.out.println("É nescessario que exista pelo menos dois veiculos cadastrados no estoque para que seja possivel realizar uma troca");
            menuinicialFuncionario();
            }

            else if(cadastroCliente.getListClientes().size() == 1){//Se houver apenas um cliente na lista tambem não sera possivel
                for (Cliente cliente : cadastroCliente.getListClientes()) { //verificando se o cliente possui algum veiculo
                    if(cliente.getVeiculosCompradosList().isEmpty()){
                        System.out.print("\033c");
                        System.out.println("O sistema possui apenas um cliente, e o mesmo não possui veiculos");
                        menuinicialFuncionario();
                    }
                }
            }
            
            //Imprimindo a lista de clientes
            System.out.print("\033c");
            System.out.println("Selecione o ID do Cliente que deseja trocar de veiculo");
           cadastroCliente.listar();

            //Entrando com a escolha do usuario de acordo com o ID dos clientes da lista
            int escolhaDoCliente = 0; //Guarda o id do cliente
            boolean clienteValido = false;
            
            do{
                try {
                    System.out.print("$ ");
                    escolhaDoCliente = input.nextInt();
                    if(cadastroCliente.getClienteID(escolhaDoCliente) != -1){
                        clienteValido = true;
                    }
                    else{
                        System.out.println("O ID digitado não corresponde a nenhum cliente");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine(); 
                }

            }while(!clienteValido);
            input.nextLine();

            //Imprimindo os veiculos do cliente
            System.out.print("\033c");

            //Aqui eu inicio a logica para sobrepor o veiculo do clinte por um veiculo do estoque
            System.out.println("Selecione o ID do veiculo que o cliente deseja trocar");
            System.out.println("----------------------LISTA DE VEICULOS DO CLIENTE----------------------");
            cadastroCliente.getCliente(escolhaDoCliente).mostrarVeiculosComprados(); //Exibindo os veiculos adquiridos pelo clinte

            int escolhaVeiculoDoCliente = 0;
            boolean veiculoValido = false;

            do{
                try {
                    System.out.print("$ ");
                    escolhaVeiculoDoCliente = input.nextInt();
                    if(cadastroCliente.getCliente(escolhaDoCliente).contemVeiculo(escolhaVeiculoDoCliente)){
                        veiculoValido = true;
                    }
                    else{
                        System.out.println("O ID digitado não corresponde a nenhum veiculo");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }

            }while(!veiculoValido);
            input.nextLine();
            //colocando o indice do veiculo dentro da variavel indice_do_Veiculo_cliente
            int indice_do_Veiculo_Cliente = cadastroCliente.getCliente(escolhaDoCliente).retornaIndiceVeiculoClinte(escolhaVeiculoDoCliente);

            //imprimindo a lista de Veiculos cadastrados
            System.out.print("\033c");
            System.out.println("Selecione o ID do veiculo que o Cliente dejesa antepor");
            System.out.println("----------------------LISTA DE VEICULOS CADASTRADOS----------------------");
            for (Veiculo veiculo : cadastroVeiculo.getListVeiculos()) {
                System.out.println(veiculo + "\n");
            }
            
            int escolhaVeiculo = 0;
            boolean escolhaVeiculoValido = false;

            do {
                try {
                    System.out.print("$ ");
                    escolhaVeiculo = input.nextInt();
                    if (cadastroVeiculo.getVeiculoID(escolhaVeiculo) != -1) {
                        escolhaVeiculoValido = true;
                    }
                    else{
                        System.out.println("O ID digitado não corresponde a nenhum veiculo");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }
            } while (!escolhaVeiculoValido);
            input.nextLine();
            System.out.print("\033c");
            cadastroCliente.getCliente(escolhaDoCliente).getVeiculosCompradosList().set(indice_do_Veiculo_Cliente, cadastroVeiculo.getVeiculo(escolhaVeiculo));/*fazendo a substituição dos veiculos,
            usei o metodo getCliente para selecionar o cliente e listar seus veiculos, apos isso usei o metodo set() do arrayList e passei o indice do veiculo do cliente que sera substituido
            e um veiculo do estoque que sera posto no lugar */
            menuinicialFuncionario();
            
        //Se não houver clientes cadastrados
        } else if (cadastroCliente.getListClientes().isEmpty()) {
            System.out.print("\033c");
            System.out.print("Erro, você ainda não cadastrou nenhum Cliente\n");
            menuinicialFuncionario();
        //Se não houver veiculos cadastrados
        } else if (cadastroVeiculo.getListVeiculos().isEmpty()) {
            System.out.print("\033c");
            System.out.print("Erro, você ainda não cadastrou nenhum Veiculo\n");
            menuinicialFuncionario();
        }        

    }

    public void removerVeiculoCliente(){
        if(!cadastroCliente.getListClientes().isEmpty()){
           
            //Se houver apenas um cliente na lista
            if(cadastroCliente.getListClientes().size() == 1){
                for (Cliente cliente : cadastroCliente.getListClientes()) {
                    if(cliente.getVeiculosCompradosList().isEmpty()){
                        System.out.print("\033c");
                        System.out.println("O sistema possui apenas um cliente, e o mesmo não possui veiculos");
                        menuinicialFuncionario();
                    }
                }
            }
            else if(cadastroCliente.getListClientes().size() > 1){
                int cont = 0;
                for (Cliente cliente : cadastroCliente.getListClientes()) {
                    if(cliente.getVeiculosCompradosList().isEmpty()){
                        cont++;
                    }
                }
                if(cont == cadastroCliente.getListClientes().size()){
                    System.out.println("O sistema não possui nenhum cliente que tenha comprado algum veiculo");
                    menuinicialFuncionario();
                }
            }
            //Imprimindo a lista de clientes
            System.out.print("\033c");
            System.out.println("Selecione o ID do cliente");
            System.out.println("----------------------LISTA DE CLIENTES CADASTRADOS----------------------\n");
            for (Cliente cliente : cadastroCliente.getListClientes()) {
                System.out.println(cliente + "\n");
            }

            //Entrando com a escolha do usuario de acordo com o ID dos clientes da lista
            int escolhaDoCliente = 0; //Guarda o id do cliente
            boolean clienteValido = false;
            
            do{
                try {
                    System.out.print("$ ");
                    escolhaDoCliente = input.nextInt();
                    if(cadastroCliente.getClienteID(escolhaDoCliente) != -1){
                        clienteValido = true;
                    }
                    else{
                        System.out.println("O ID digitado não corresponde a nenhum cliente");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }

            }while(!clienteValido);
            input.nextLine();

            System.out.print("\033c");
            System.out.println("Selecione o ID do veiculo que deseja remover");
            System.out.println("----------------------LISTA DE VEICULOS DO CLIENTE----------------------");
            cadastroCliente.getCliente(escolhaDoCliente).mostrarVeiculosComprados();

            int escolhaVeiculoDoCliente = 0;
            boolean veiculoValido = false;

            do{
                try {
                    System.out.print("$ ");
                    escolhaVeiculoDoCliente = input.nextInt();
                    if(cadastroCliente.getCliente(escolhaDoCliente).contemVeiculo(escolhaVeiculoDoCliente)){
                        veiculoValido = true;
                    }
                    else{
                        System.out.println("O ID digitado não corresponde a nenhum veiculo");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }

            }while(!veiculoValido);
            input.nextLine();
            int indice_do_Veiculo_Cliente = cadastroCliente.getCliente(escolhaDoCliente).retornaIndiceVeiculoClinte(escolhaVeiculoDoCliente);

            cadastroCliente.getCliente(escolhaDoCliente).getVeiculosCompradosList().remove(indice_do_Veiculo_Cliente);
            System.out.print("\033c");
            System.out.print("Veiculo removido com sucesso\n");
            menuinicialFuncionario();
            
        //Se não houver clientes cadastrados
        } else if (cadastroCliente.getListClientes().isEmpty()) {
            System.out.print("\033c");
            System.out.print("Erro, você ainda não cadastrou nenhum Cliente\n");
            menuinicialFuncionario();
        } 
    }
}
