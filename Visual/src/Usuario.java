/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Richard
 */
public class Usuario implements Registro {
    protected int codigo;
    protected String login = "";
    protected String nome = "";
    protected String senha = "";
    protected String cpf = "";
    protected String nasc = "";
    protected String email = "";
    
    public Usuario() {
        this.codigo = -1;
        this.login = "";
        this.nome = "";
        this.senha = "";
        this.cpf = "";
        this.nasc = "";
        this.email = "";
    }
    
    public Usuario(String nome, String login,String senha, String cpf, String nasc, String email) {
        this.codigo = -1;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nasc = nasc;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getString() {
        return nome;
    }

    @Override
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream registro = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( registro );
        saida.writeInt(codigo);
        saida.writeUTF(nome);
        saida.writeUTF(login);
        saida.writeUTF(senha);
        saida.writeUTF(cpf);
        saida.writeUTF(nasc);
        saida.writeUTF(email);
        return registro.toByteArray();
    }

    @Override
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream registro = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(registro);
        codigo = entrada.readInt();
        nome = entrada.readUTF();
        login = entrada.readUTF();
        senha = entrada.readUTF();
        cpf = entrada.readUTF();
        nasc = entrada.readUTF();
        email = entrada.readUTF();
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }    

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", nasc=" + nasc + ", email=" + email + '}';
    }
    
}
