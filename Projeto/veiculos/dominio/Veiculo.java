package veiculos.dominio;

public abstract class Veiculo{

    protected String nome;
    protected long valor;
    protected boolean isCad;
    protected int ID;
    protected int ano;


    public Veiculo(String nome, long valor, int ano, int ID) {
        this.nome = nome;
        this.valor = valor;
        this.ano = ano;
        this.isCad = false;
        this.ID = ID;
    }
    
    public int getID() {
        return ID;
    }


    public void setID(int iD) {
        this.ID = iD;
    }
    

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getValor() {
        return valor;
    }
    public void setValor(long valor) {
        this.valor = valor;
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
        result = prime * result + ID;
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
        Veiculo other = (Veiculo) obj;
        if (ID != other.ID)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String ss = "\u001b[33mNome----------"+"\u001b[37m"+this.nome+"\n"+
                    "\u001b[33mValor---------"+"\u001b[37m$"+this.valor+"\n"+
                    "\u001b[33mCadastro------"+"\u001b[37m"+this.isCad+"\n"+
                    "\u001b[34mID---------"+"\u001b[37m"+this.ID+"\u001b[0m\n\n";
                return ss;

    }

}