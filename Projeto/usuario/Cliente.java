package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menu.menuPrincipal;
import veiculos.dominio.Veiculo;

public class Cliente {
   
    protected String nome;
    protected int idade;
    protected boolean isCad;
    protected int ID;
    List<Veiculo> LISTA_DE_VEICULOS_COMPRADOS;
    Scanner input = new Scanner(System.in);

    public Cliente(String nome, int idade, int ID) {
        this.nome = nome;
        this.idade = idade;
        this.LISTA_DE_VEICULOS_COMPRADOS = new ArrayList<>();
        this.ID = ID;
    }

    public void rmVeiculoCliente(){
        System.out.print("\033c");
        if (!LISTA_DE_VEICULOS_COMPRADOS.isEmpty()) {
            for (Veiculo veiculo : LISTA_DE_VEICULOS_COMPRADOS) {
                System.out.println(veiculo + "\n");
            }
            System.out.println("Digite o Id do veiculo que deseja remover");

            int veiculo = 0;
            boolean veiculoValido = false;

            do {
                try {
                    System.out.print("$ ");
                    veiculo = input.nextInt();
                    if (contemVeiculo(veiculo)) {
                        veiculoValido = true;
                    } else {
                        System.out.println("O ID digitado não corresponde a nenhum veiculo");
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido");
                    input.nextLine();
                }
            } while (!veiculoValido);
            input.nextLine();

            LISTA_DE_VEICULOS_COMPRADOS.remove(getVeiculo(veiculo));
            menuPrincipal.INSTACE.menuinicialFuncionario();
        }
    }

    public void receberVeiculo(Veiculo veiculo) {
        LISTA_DE_VEICULOS_COMPRADOS.add(veiculo);
    }

    public void mostrarVeiculosComprados(){
        for(Veiculo veiculo : LISTA_DE_VEICULOS_COMPRADOS){
            System.out.println(veiculo + "\n");
        }
    }

    //retorna a lista de veiculos comprados
    public List<Veiculo> getVeiculosCompradosList(){
        return LISTA_DE_VEICULOS_COMPRADOS;
    }

    //retorna true se o veiculo existir e false se não existir
    public boolean contemVeiculo(int id){
        for (Veiculo veiculo : LISTA_DE_VEICULOS_COMPRADOS) {
            if(veiculo.getID() == id){
                return true;
            }
        }
        return false;
    }

    //retorna o um veiculo
    public Veiculo getVeiculo(int id){
        if(contemVeiculo(id)){
            for (Veiculo veiculo : LISTA_DE_VEICULOS_COMPRADOS) {
                if(veiculo.getID() == id){
                    return veiculo;
                }
            }
        }
        return null;
    }

    //retorna o indice de um veiculo
    public int retornaIndiceVeiculoClinte(int id){
        for(int i = 0; i<LISTA_DE_VEICULOS_COMPRADOS.size(); i++){
            if(LISTA_DE_VEICULOS_COMPRADOS.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isCad() {
        return isCad;
    }

    public void setCad(boolean isCad) {
        this.isCad = isCad;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    public String getVeiculosComprados(){
        String s = "";
        for (Veiculo veiculo : LISTA_DE_VEICULOS_COMPRADOS) {
                s+=veiculo.toString();
        }
        return s;
    }

    @Override
    public String toString() {
        String sb;
        sb = "\u001b[33mNome-------" + "\u001b[37m" + this.nome + "\n" +
        "\u001b[33mIdade------" + "\u001b[37m" + this.idade + "\n" +
        "\u001b[33mCadastro------" + "\u001b[37m" + this.isCad + "\n" +
        "\u001b[34mID------" + "\u001b[37m" + this.ID + "\n" +
        "\u001b[33m\n-------Veiculos comprados------\u001b[0m\n" + getVeiculosComprados();

        return sb;
    }

}
