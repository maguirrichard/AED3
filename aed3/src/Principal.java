import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Richard
 */
public class Principal {
    
    private static Scanner console = new Scanner(System.in);
    private static ArquivoIndexado<Entrega> arquivo1;
    private static ArquivoIndexado<Usuario> arquivo2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        principal();
    }
    
    public static void principal() throws Exception{
        // menu
        int opcao;
        do {
            System.out.println("\n\nESCOLHA\n");
            System.out.println("1 - Usuario");
            System.out.println("2 - Entrega");
            System.out.println("0 - Sair");
            System.out.print("\nOpcao: ");
            opcao = Integer.valueOf(console.nextLine());
               
            switch(opcao) {
                case 1:  Pergunta(); break;
                case 2:  Entregas(); break;
                case 0:  break;
                default: System.out.println("OpÃ§Ã£o invÃ¡lida");
            }
        }while(opcao != 0);
    }
    
    public static void Pergunta() throws Exception {
        arquivo2 = new ArquivoIndexado<>(Usuario.class, "usuario.db", "usuario1.idx", "usuario2.idx");
        int opcao;
        System.out.println("\n\nESCOLHA\n");
        System.out.println("1 - Login");
        System.out.println("2 - Criar Usuario");
        System.out.println("0 - Sair");
        System.out.print("\nOpcao: ");
        opcao = Integer.valueOf(console.nextLine());
               
        switch(opcao) {
            case 1:  Login(); break;
            case 2:  criarUsuario(); break;
            case 0:  break;
            default: System.out.println("OpÃ§Ã£o invÃ¡lida");
        }
      
    }
    
    public static void Usuarios(Usuario u){
        try {
           arquivo2 = new ArquivoIndexado<>(Usuario.class, "usuario.db", "usuario1.idx", "usuario2.idx");
           
           // menu
           int opcao;
           do {
               System.out.println("\n\nPAINEL DE USUARIO\n");
               System.out.println("1 - Listar usuarios");
               System.out.println("2 - Alterar usuario");
               System.out.println("3 - Excluir usuario");
               System.out.println("4 - Entregas");
               System.out.println("0 - Sair");
               System.out.print("\nOpcao: ");
               opcao = Integer.valueOf(console.nextLine());
               
               switch(opcao) {
                   case 1:  listarUsuario(); break;
                   case 2:  alterarUsuario(); break;
                   case 3:  excluirUsuario(); break;
                   case 4:  EntregasLogged(u); break;
                   case 0:  System.out.print("\nDeseja sair? ");
                            char confirma = console.nextLine().charAt(0);
                            if(confirma=='s' || confirma=='S') { 
                                opcao = 0;
                            }
                            break;
                   default: System.out.println("OpÃ§Ã£o invÃ¡lida");
               }
               
           } while(opcao!=0);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    

    
    public static void Login() throws Exception{
        System.out.println("\nLOGIN");

        String nome;
        System.out.print("Nome: ");
        nome = console.nextLine();
        if(nome.length() <=0) 
           return;
       
        Usuario u;
        if( (u = (Usuario)arquivo2.buscarString(nome))!=null ) {
            //System.out.println(u);
            String senha;
            System.out.print("Senha: ");
            senha = console.nextLine();
            if(senha.equals(u.getSenha())){
                System.out.println("\n\nLogado com sucesso");
                System.out.println("Aperte ENTER para continuar!");
                System.in.read();
                Usuarios(u);
            }else System.out.println("Usuario ou Senha invalidos!");
            
        }else System.out.println("Usuario nÃ£o encontrado");
    }
    
    public static void listarUsuario() throws Exception {
       
        Object[] usuario = arquivo2.listar();
       
        for(int i=0; i<usuario.length; i++) {
            System.out.println((Usuario)usuario[i]);
        }
       
    }
    
    public static void criarUsuario() throws Exception {
       
        String nome;
        String senha;
        String cpf;
        String nasc;
        String email;
       
        System.out.println("\nUSUARIO");
        System.out.print("Nome: ");
        nome = console.nextLine();
        System.out.print("Senha: ");
        senha = console.nextLine();
        System.out.print("CPF: ");
        cpf = console.nextLine();
        System.out.print("Data de Nascimento: ");
        nasc = console.nextLine();
        System.out.print("E-mail: ");
        email = console.nextLine();
       
        System.out.print("\nConfirma cadastro? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
           Usuario u = new Usuario(nome, senha, cpf, nasc, email);
           int cod = arquivo2.incluir(u);
           System.out.println("Usuario cadastrado com codigo: "+cod);
        }
    }
    
    public static void alterarUsuario() throws Exception {
       
        System.out.println("\nALTERAÃ‡ÃƒO");

        int codigo;
        System.out.print("CÃ³digo: ");
         codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0) 
           return;
       
        Usuario u;
        if( (u = (Usuario)arquivo2.buscarCodigo(codigo))!=null ) {
            System.out.println(u);
            
            String nome;
            String senha;
            String cpf;
            String nasc;
            String email;
       
            System.out.println("\nENTREGA");
            System.out.print("Nome: ");
            nome = console.nextLine();
            System.out.print("Senha: ");
            senha = console.nextLine();
            System.out.print("CPF: ");
            cpf = console.nextLine();
            System.out.print("Data de Nascimento: ");
            nasc = console.nextLine();
            System.out.print("E-mail: ");
            email = console.nextLine();

            System.out.print("\nConfirma alteraÃ§Ã£o? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                
                u.nome = (nome.length()>0?nome:u.nome);
                u.senha = (senha.length()>0?senha:u.senha);
                u.cpf = (cpf.length()>0?cpf:u.cpf);                
                u.nasc = (nasc.length()>0?nasc:u.nasc);
                u.email = (email.length()>0?email:u.email);
                
                if( arquivo2.alterar(u) ) 
                    System.out.println("Usuario alterado.");
                else
                    System.out.println("Usuario nao pode ser alterado.");
            }
        }
        else
            System.out.println("Usuario nao encontrado");
       
    }
    
    public static void excluirUsuario() throws Exception {
       
        System.out.println("\nEXCLUSAO");

        int codigo;
        System.out.print("Codigo: ");
        codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0) 
            return;
       
        Usuario u;
        if( (u = (Usuario)arquivo2.buscarCodigo(codigo))!=null ) {
            System.out.println(u);
            System.out.print("\nConfirma exclusao? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                if( arquivo2.excluir(codigo) ) {
                    System.out.println("Entrega desfeita.");
                }
            }
        }
        else
            System.out.println("Entrega nÃ£o encontrada");
       
    }
    
    public static void EntregasLogged(Usuario u){
        System.out.println(u);
        try {
           arquivo1 = new ArquivoIndexado<>(Entrega.class, "entregas.db", "entregas1.idx", "entregas2.idx");
           
           // menu
           int opcao;
           do {
               System.out.println("\n\nSISTEMA DE ENTREGAS\n");
               System.out.println("1 - Listar entregas");
               System.out.println("2 - Criar entrega");
               System.out.println("3 - Alterar entrega");
               System.out.println("4 - Excluir entrega");
               System.out.println("5 - Buscar entrega por cÃ³digo");
               System.out.println("6 - Buscar entrega por produto");
               System.out.println("7 - Reorganizar arquivo");
               System.out.println("9 - Povoar BD");
               System.out.println("0 - Sair");
               System.out.print("\nOpcao: ");
               opcao = Integer.valueOf(console.nextLine());
               
               switch(opcao) {
                   case 1:  listarEntregas(); break;
                   case 2:  criarEntrega(); break;
                   case 3:  alterarEntrega(); break;
                   case 4:  excluirEntrega(); break;
                   case 5:  break;
                   case 6:  break;
                   case 7:  break;
                   case 9:  break;
                   case 0:  break;
                   default: System.out.println("OpÃ§Ã£o invÃ¡lida");
               }
               
           } while(opcao!=0);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    
    public static void Entregas(){
        try {
           arquivo1 = new ArquivoIndexado<>(Entrega.class, "entregas.db", "entregas1.idx", "entregas2.idx");
           
           // menu
           int opcao;
           do {
                System.out.println("\n\nENTREGAS\n");
                System.out.println("1 - Listar entregas");
                System.out.println("0 - Sair");
                System.out.print("\nOpcao: ");
                opcao = Integer.valueOf(console.nextLine());
               
               switch(opcao) {
                   case 1:  listarEntregas(); break;
                   case 0:  break;
                   default: System.out.println("OpÃ§Ã£o invÃ¡lida");
               }
               
           } while(opcao!=0);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    
    public static void listarEntregas() throws Exception {
       
        Object[] entregas = arquivo1.listar();
       
        for(int i=0; i<entregas.length; i++) {
            System.out.println((Entrega)entregas[i]);
        }
       
    }
    
    public static void criarEntrega() throws Exception {
       
        int idTransp;
        int idEmpresa1;
        int idEmpresa2;
        int idProd;
        String endereco;
       
        System.out.println("\nENTREGA");
        System.out.print("ID do transportador: ");
        idTransp = Integer.valueOf(console.nextLine());
        System.out.print("ID da empresa entregadora: ");
        idEmpresa1 = Integer.valueOf(console.nextLine());
        System.out.print("ID da empresa receptora: ");
        idEmpresa2 = Integer.valueOf(console.nextLine());
        System.out.print("ID do produto: ");
        idProd = Integer.valueOf(console.nextLine());
        System.out.print("Endereco de entrega: ");
        endereco = console.nextLine();
       
        System.out.print("\nConfirma entrega? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
           Entrega l = new Entrega(idTransp, idEmpresa1, idEmpresa2, idProd, endereco);
           int cod = arquivo1.incluir(l);
           System.out.println("Livro incluÃ­do com cÃ³digo: "+cod);
        }
    }
    
    public static void alterarEntrega() throws Exception {
       
        System.out.println("\nALTERAÃ‡ÃƒO");

        int codigo;
        System.out.print("CÃ³digo: ");
         codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0) 
           return;
       
        Entrega l;
        if( (l = (Entrega)arquivo1.buscarCodigo(codigo))!=null ) {
            System.out.println(l);
            
            String idTransp;
            String idEmpresa1;
            String idEmpresa2;
            String idProd;
            String endereco;
            String feita;
       
            System.out.println("\nENTREGA");
            System.out.print("ID do transportador: ");
            idTransp = console.nextLine();
            System.out.print("ID da empresa entregadora: ");
            idEmpresa1 = console.nextLine();
            System.out.print("ID da empresa receptora: ");
            idEmpresa2 = console.nextLine();
            System.out.print("ID do produto: ");
            idProd = console.nextLine();
            System.out.print("Endereco de entrega: ");
            endereco = console.nextLine();
            System.out.print("Entrega feita?: ");
            feita = console.nextLine();

            System.out.print("\nConfirma alteraÃ§Ã£o? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                
                l.idTransp = (idTransp.length()>0?Integer.valueOf(idTransp):l.idTransp);
                l.idEmpresa1 = (idEmpresa1.length()>0?Integer.valueOf(idEmpresa1):l.idEmpresa1);
                l.idEmpresa2 = (idEmpresa2.length()>0?Integer.valueOf(idEmpresa2):l.idEmpresa2);                
                l.idProd = (idProd.length()>0?Integer.valueOf(idProd):l.idProd);
                l.endereco = (endereco.length()>0?endereco:l.endereco);
                l.feita = (feita.equals("s")||feita.equals("S")?true:l.feita);
                
                if( arquivo1.alterar(l) ) 
                    System.out.println("Entrega alterada.");
                else
                    System.out.println("Entrega nÃ£o pode ser alterada.");
            }
        }
        else
            System.out.println("Livro nÃ£o encontrado");
       
    }
    
    public static void excluirEntrega() throws Exception {
       
        System.out.println("\nEXCLUSÃƒO");

        int codigo;
        System.out.print("CÃ³digo: ");
        codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0) 
            return;
       
        Entrega l;
        if( (l = (Entrega)arquivo1.buscarCodigo(codigo))!=null ) {
            System.out.println(l);
            System.out.print("\nConfirma exclusÃ£o? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                if( arquivo1.excluir(codigo) ) {
                    System.out.println("Entrega desfeita.");
                }
            }
        }
        else
            System.out.println("Entrega nÃ£o encontrada");       
   }    
}