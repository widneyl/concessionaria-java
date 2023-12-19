package cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.menuPrincipal;
import usuario.Cliente;

public class CadastroDeClientes implements InterF {

    Scanner input = new Scanner(System.in);
    protected List<Cliente> LISTA_DE_CLIENTES_CADASTRADOS = new ArrayList<>();
    Cadastro cadastro = new Cadastro();

    //Adiciona o cliente a Lista
    public void addCliente(Cliente cliente) {
        if (getClienteID(cliente.getID()) != 1) { //Usei o getClienteID para verificar se o cliente ja existe na lista de cadastrados, usei o getID do cliente como parametro do metodo
            LISTA_DE_CLIENTES_CADASTRADOS.add(cliente);
            cliente.setCad(true); //Aqui ele passa o cadastro para verdadeiro
            System.out.print("\u001b[32mCliente cadastrado com sucesso!\u001b[0m\n");
        } else {
            System.out.print("\u001b[31mCliente ja na lista de cadastro!\u001b[0m\n");
        }
    }

    //Remover um cliente da lista
    public void rmCliente() {
        System.out.print("\033c");
        if (!LISTA_DE_CLIENTES_CADASTRADOS.isEmpty()) {
            listar();
            System.out.println("Digite o ID do cliente que deseja remover da lista");
            int escolha = 0;
            boolean escolhaValida = false;

            do {
                try {
                    System.out.print("$ ");
                    escolha = input.nextInt();
                    if (getClienteID(escolha) != -1) { //Usei o metodo getClinteID para verificar se o ID digitado corresponde a algum cliente
                        escolhaValida = true;
                    } else {
                        System.out.println("Opção inválida.");
                        input.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida.");
                    input.nextLine();
                }
            } while (!escolhaValida);
            input.nextLine();

            LISTA_DE_CLIENTES_CADASTRADOS.remove(getCliente(escolha)); /*Usei o metodo getCliente como parametro do .remove para retornar o indice do cliente e usar o indice
            retornado para apagar da lista*/

            System.out.print("\033c");
            menuPrincipal.INSTACE.menuinicialFuncionario();

        } else {
            listar();
        }
    }


    //Metodo para realização de um novo cadastro, esse metodo chama o metodo realizarCadastroCliente() da classe cadastro
    @Override
    public void realizarUmCadastro() {
        System.out.print("\033c");
        System.out.println("--------------------< BOAS VINDAS AO CADASTRO DE NOVOS CLIENTES >--------------------");
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
            Cliente cliente = cadastro.realizarCadastroCliente(); //fazendo a chamada do metodo de realização de cadastro
            addCliente(cliente);
            menuPrincipal.INSTACE.menuinicialFuncionario();
        } else {
            System.out.print("\033c");
            menuPrincipal.INSTACE.menuinicialFuncionario();
        }
    }

    //retorna um cliente
    public Cliente getCliente(int id) {
        for (int i = 0; i < LISTA_DE_CLIENTES_CADASTRADOS.size(); i++) {
            if (LISTA_DE_CLIENTES_CADASTRADOS.get(i).getID() == id) {
                return LISTA_DE_CLIENTES_CADASTRADOS.get(i);
            }
        }
        return null;
    }

    //Retorna o indice de um cliente
    public int indiceCliente(int id){
        for (int i = 0; i < LISTA_DE_CLIENTES_CADASTRADOS.size(); i++) {
            if (LISTA_DE_CLIENTES_CADASTRADOS.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }
    //Retorna 1 se o cliente existir e -1 se não existir
    public int getClienteID(int id) {
        for (int i = 0; i < LISTA_DE_CLIENTES_CADASTRADOS.size(); i++) {
            if (LISTA_DE_CLIENTES_CADASTRADOS.get(i).getID() == id) {
                return 1;
            }
        }
        return -1;
    }

    //retorna a lista e clientes
    public List<Cliente> getListClientes() {
        return LISTA_DE_CLIENTES_CADASTRADOS;
    }

    //Metodo para listar os clientes
    @Override
    public void listar() {
        if (!LISTA_DE_CLIENTES_CADASTRADOS.isEmpty()) {
            System.out.println("----------------------LISTA DE CLIENTES CADASTRADOS----------------------\n");
            for (Cliente cliente : LISTA_DE_CLIENTES_CADASTRADOS) {
                System.out.println(cliente + "\n");
            }
        //Se ainda não houver clientes cadastrados 
        } else {
            System.out.println("----------------------AINDA NÃO EXISTEM CLIENTES CADASTRADOS----------------------");
            System.out.println("[1] Realizar um cadastro");
            System.out.println("[2] Voltar\n");

            int op = 0;
            boolean entradavalida = false;

            do {
                try {
                    System.out.print("$ ");
                    op = input.nextInt();
                    if (op > 0 && op <= 3) {
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
}
