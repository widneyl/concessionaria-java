package cadastro;

import java.util.Scanner;
import usuario.Cliente;
import veiculos.Barcos.Barco;
import veiculos.Carros.Carro;
import veiculos.Motos.Moto;

public class Cadastro {
    Scanner input = new Scanner(System.in);

    //Metodo com formulario para realizar o cadastro de um novo cliente
    public Cliente realizarCadastroCliente() {
        System.out.print("\033c");
        System.out.print("\u001b[37m[+] \u001b[33mDigite o nome do cliente: \u001b[37m ");
        String nome = input.nextLine();

        boolean idadeValida = false;
        int idade = 0;
        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite a idade do cliente:\u001b[37m ");
                idade = input.nextInt();
                if (idade <= 0 || idade < 18) { //Verificando se a idade digitado foi maior ou igual a 18
                    idadeValida = false;
                    System.out.println("O cliente precisa ser maior de idade");

                } else {
                    idadeValida = true;
                }

            } catch (Exception e) {
                System.out.println("\u001b[31mfail: Entrada invalida\u001b[37m");
                idadeValida = false;
                input.nextLine();
            }
        } while (!idadeValida);
        input.nextLine();

        boolean idValido;
        int id = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ID do cliente: \u001b[37m ");
                id = input.nextInt();
                idValido = true;
                if (id < 0) {
                    idValido = false;
                    System.out.println("ID invalido");
                } else {
                    idValido = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                idValido = false;
                input.nextLine();
            }
        } while (!idValido);
        input.nextLine();
        System.out.print("\033c");
        Cliente cliente = new Cliente(nome, idade, id);
        return cliente;
    }

    //Metodo com formulario para realizar o cadastro de um novo carro
    public Carro realizarCadastroCarro() {
        System.out.print("\033c");
        System.out.print("\u001b[37m[+] \u001b[33mDigite o nome do Carro:\u001b[37m ");
        String nome = input.nextLine();

        boolean precoValido;
        long preco = 0;
        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o preço do Carro:\u001b[37m ");
                preco = input.nextLong();
                precoValido = true;
                if (preco <= 0) {
                    precoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Valor invalido");
                precoValido = false;
                input.nextLine();
            }
        } while (!precoValido);
        input.nextLine();

        boolean anoValido;
        int ano = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ano do Carro:\u001b[37m ");
                ano = input.nextInt();
                anoValido = true;
                if (ano <= 0) {
                    anoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Ano invalido");
                anoValido = false;
                input.nextLine();
            }
        } while (!anoValido);
        input.nextLine();

        boolean idValido;
        int id = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ID:\u001b[37m ");
                id = input.nextInt();
                idValido = true;
                if (id < 0) {
                    idValido = false;
                    System.out.println("ID invalido");
                } else {
                    idValido = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                idValido = false;
                input.nextLine();
            }
        } while (!idValido);
        input.nextLine();

        System.out.print("\033c");
        Carro carro = new Carro(nome, preco, ano, id);
        return carro;

    }
    //Metodo com formulario para realizar o cadastro de um novo moto
    public Moto realizarCadastroMoto() {
        System.out.print("\033c");
        System.out.print("\u001b[37m[+] \u001b[33mDigite o nome do Moto:\u001b[37m ");
        String nome = input.nextLine();

        boolean precoValido;
        long preco = 0;
        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o preço do Moto:\u001b[37m ");
                preco = input.nextLong();
                precoValido = true;
                if (preco <= 0) {
                    precoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Valor invalido");
                precoValido = false;
                input.nextLine();
            }
        } while (!precoValido);
        input.nextLine();

        boolean anoValido;
        int ano = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ano do Moto:\u001b[37m ");
                ano = input.nextInt();
                anoValido = true;
                if (preco <= 0) {
                    anoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Ano invalido");
                anoValido = false;
                input.nextLine();
            }
        } while (!anoValido);
        input.nextLine();

        boolean idValido;
        int id = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ID:\u001b[37m ");
                id = input.nextInt();
                idValido = true;
                if (id < 0) {
                    idValido = false;
                    System.out.println("ID invalido");
                } else {
                    idValido = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                idValido = false;
                input.nextLine();
            }
        } while (!idValido);
        input.nextLine();

        System.out.print("\033c");
        Moto moto = new Moto(nome, preco, ano, id);
        return moto;

    }

    //Metodo com formulario para realizar o cadastro de um novo Barco
    public Barco realizarCadastroBarco() {
        System.out.print("\033c");
        System.out.print("\u001b[37m[+] \u001b[33mDigite o nome do Barco:\u001b[37m ");
        String nome = input.nextLine();

        boolean precoValido;
        long preco = 0;
        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o preço do Barco:\u001b[37m ");
                preco = input.nextLong();
                precoValido = true;
                if (preco <= 0) {
                    precoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Valor invalido");
                precoValido = false;
                input.nextLine();
            }
        } while (!precoValido);
        input.nextLine();

        boolean anoValido;
        int ano = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ano do Barco:\u001b[37m ");
                ano = input.nextInt();
                anoValido = true;
                if (preco <= 0) {
                    anoValido = false;
                }
            } catch (Exception e) {
                System.out.println("Ano invalido");
                anoValido = false;
                input.nextLine();
            }
        } while (!anoValido);
        input.nextLine();

        boolean idValido;
        int id = 0;

        do {
            try {
                System.out.print("\u001b[37m[+] \u001b[33mDigite o ID:\u001b[37m ");
                id = input.nextInt();
                idValido = true;
                if (id < 0) {
                    idValido = false;
                    System.out.println("ID invalido");
                } else {
                    idValido = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                idValido = false;
                input.nextLine();
            }
        } while (!idValido);
        input.nextLine();

        System.out.print("\033c");
        Barco barco = new Barco(nome, preco, ano, id);
        return barco;

    }
}
