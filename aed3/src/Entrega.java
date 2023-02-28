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
    protected int idTransp;
    protected int idEmpresa1;
    protected int idEmpresa2;
    protected int idProd;
    protected String endereco;
    protected boolean feita;
    
    public Entrega (int idTransp, int idEmpresa1, int idEmpresa2, int idProd, String endereco) {
        this.idTransp = idTransp;
        this.idEmpresa1 = idEmpresa1;
        this.idEmpresa2 = idEmpresa2;
        this.idProd = idProd;
        this.endereco = endereco;
        this.feita = false;
    }
    
    public Entrega () {
        this.codigo = -1;
        this.idTransp = -1;
        this.idEmpresa1 = -1;
        this.idEmpresa2 = -1;
        this.idProd = -1;
        this.endereco = "";
        this.feita = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdTransp() {
        return idTransp;
    }

    public void setIdTransp(int idTransp) {
        this.idTransp = idTransp;
    }

    public int getIdEmpresa2() {
        return idEmpresa2;
    }

    public void setIdEmpresa2(int idEmpresa2) {
        this.idEmpresa2 = idEmpresa2;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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
        return "Entrega{" + "codigo=" + codigo + ", idTransp=" + idTransp + ", idEmpresa1=" + idEmpresa1 + ", idEmpresa2=" + idEmpresa2 + ", idProd=" + idProd + ", endereco=" + endereco + ", feita=" + feita + '}';
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream registro = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( registro );
        saida.writeInt(codigo);
        saida.writeInt(idTransp);
        saida.writeInt(idEmpresa1);
        saida.writeInt(idEmpresa2);
        saida.writeInt(idProd);
        saida.writeUTF(endereco);
        saida.writeBoolean(feita);
        return registro.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream registro = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(registro);
        codigo = entrada.readInt();
        idTransp = entrada.readInt();
        idEmpresa1 = entrada.readInt();
        idEmpresa2 = entrada.readInt();
        idProd = entrada.readInt();
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
