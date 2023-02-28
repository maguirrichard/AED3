import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Richard
 */
public class Entrega implements Registro {
    protected int codigo;
    protected String transp;
    protected String empresa1;
    protected String empresa2;
    protected String prod;
    protected String endereco;
    protected boolean feita;
    
    public Entrega (String transp, String empresa1, String empresa2, String prod, String endereco) {
        this.transp = transp;
        this.empresa1 = empresa1;
        this.empresa2 = empresa2;
        this.prod = prod;
        this.endereco = endereco;
        this.feita = false;
    }
    
    public Entrega () {
        this.codigo = -1;
        this.transp = "";
        this.empresa1 = "";
        this.empresa2 = "";
        this.prod = "";
        this.endereco = "";
        this.feita = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTransp() {
        return transp;
    }

    public void setTransp(String transp) {
        this.transp = transp;
    }

    public String getEmpresa1() {
        return empresa1;
    }

    public void setEmpresa1(String empresa1) {
        this.empresa1 = empresa1;
    }

    public String getEmpresa2() {
        return empresa2;
    }

    public void setEmpresa2(String empresa2) {
        this.empresa2 = empresa2;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    @Override
    public String toString() {
        return "Transportador = " + transp + ", Empresa 1 = " + empresa1 + ", Empresa 2 = " + empresa2 + ", Prod = " + prod + ", Endereco = " + endereco + ", Encerrada? " + feita;
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream registro = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( registro );
        saida.writeInt(codigo);
        saida.writeUTF(transp);
        saida.writeUTF(empresa1);
        saida.writeUTF(empresa2);
        saida.writeUTF(prod);
        saida.writeUTF(endereco);
        saida.writeBoolean(feita);
        return registro.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream registro = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(registro);
        codigo = entrada.readInt();
        transp = entrada.readUTF();
        empresa1 = entrada.readUTF();
        empresa2 = entrada.readUTF();
        prod = entrada.readUTF();
        endereco = entrada.readUTF();
        feita = entrada.readBoolean();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }    

    @Override
    public String getString() {
        return endereco;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
