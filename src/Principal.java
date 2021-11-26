
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variáveis normais
        String usuario;
        String senha;
        int opcao;
        int opcaoDeCliente = -1;
        int opcaoDeProduto = -1;
        boolean vetorCheio = true;
        int clienteParaDeletar;
        int clienteParaAlterar;
        int produtoParaDeletar;
        int produtoParaAlterar;
        char opcaoDeRelatorio;
        char deletarBancoDeDados;
        int contadorTotalDeClientes = 0;
        int contadorTotalDeProdutos = 0;
        int contadorTotalDeVendas = 0;
        float maiorRefeicao = Integer.MIN_VALUE;
        float menorRefeicao = Integer.MAX_VALUE;
        String maiorProduto = "";
        String menorProduto = "";
        float total = 0;
        int codigo;

        
        //Vetores
        int clienteCodigo[] = new int[10];
        String clienteNome[] = new String[10];
        String clienteEndereco[] = new String[10];
        String clienteCidade[] = new String[10];
        int produtoCodigo[] = new int[10];
        String produtoDescricao[] = new String[10];
        float produtoValor[] = new float[10];
        int refeicaoCodigo[] = new int[20];
        int refeicaoCliente[] = new int[20];
        int refeicaoProduto[] = new int[20];
        String refeicaoData[] = new String[20];
        float soma[] = new float[20];
        
//==============================================================================

        System.out.println("==============================================");
        System.out.println("Bem Vindo ao Sistema de Controle de Refeição");
        System.out.println("==============================================");
        System.out.println("Usuário:");
        usuario = teclado.next();
        System.out.println("Senha:");
        senha = teclado.next();
        
        if(!usuario.equals("jj") || !senha.equals("jj")){
            System.out.println("Usuário ou senha errados. Tente novamente.");
            System.exit(0);
        }
        
        do{
        System.out.println("========= Menu de Opções =========");
        System.out.println(" 1 - Cadastro de Cliente");
        System.out.println(" 2 - Cadastro de Produto");
        System.out.println(" 3 - Lançamento de Vendas");
        System.out.println(" 4 - Listar dados do Cliente");
        System.out.println(" 5 - Listar dados dos Produtos");
        System.out.println(" 6 - Listar vendas cadastradas");
        System.out.println(" 7 - Emitir nota fiscal");
        System.out.println(" 8 - Limpar banco de dados");
        System.out.println(" 9 - Relatório - Maior valor da refeição do cliente");
        System.out.println("10 - Relatório - Menor valor da refeição do cliente");
        System.out.println("11 - Relatório - Total das refeições do cliente");
        System.out.println("Digite Zero para terminar");
        System.out.println("==================================");
        System.out.println(" ");
        System.out.println("Digite a opção desejada:");
        opcao = teclado.nextInt();
        
        if(opcao < 0 || opcao > 11){
            System.out.println("Opção Inválida!!");
            System.exit(0);
        }
        
//==============================================================================       

        switch(opcao){
            
            case 1:
                do{
                System.out.println("=========Menu de Opções de Clientes=========");
                System.out.println("1 - Inserir Cliente");
                System.out.println("2 - Deletar Cliente");
                System.out.println("3 - Alterar Cliente");
                System.out.println("Digite Zero para voltar ao menu anterior");
                System.out.println("===================================");
                opcaoDeCliente = teclado.nextInt();
                
                if(opcaoDeCliente == 0){
                    break;
                }
                
                if(opcaoDeCliente == 1){
                    for(int i = 0; i < clienteCodigo.length; i++){
                        if(clienteCodigo[i] == 0){
                            System.out.println("===================");
                            System.out.println("CADASTRO DE CLIENTE");
                            System.out.println("===================");
                            
                            System.out.print("Código: ");
                            clienteCodigo[i] = teclado.nextInt();
                            teclado.nextLine();
                            
                            System.out.print("Nome do Cliente: ");
                            clienteNome[i] = teclado.nextLine();
                            
                            System.out.print("Endereço: ");
                            clienteEndereco[i] = teclado.nextLine();
                            
                            System.out.print("Cidade: ");
                            clienteCidade[i] = teclado.nextLine();
                            
                            System.out.println(" ");
                            System.out.println("Cadastro concluído!");
                            
                            contadorTotalDeClientes++;
                            vetorCheio = false;
                            break;
                        }
                        if(vetorCheio){
                            System.out.println("Não há como inserir o dado, espaço insuficiente.");
                        }
                    }
                }
                
                if(opcaoDeCliente == 2){
                            System.out.println("===================");
                            System.out.println("DELETAR CLIENTES");
                            System.out.println("===================");
                            
                            System.out.println("Informe o código do cliente:");
                            clienteParaDeletar = teclado.nextInt();
                            
                            for(int i = 0; i < clienteCodigo.length; i++){
                                if(clienteParaDeletar == clienteCodigo[i]){
                                    clienteCodigo[i] = 0;
                                    clienteNome[i] = "";
                                    clienteEndereco[i] = "";
                                    clienteCidade[i] = "";
                                    
                                    contadorTotalDeClientes--;
                                    System.out.println("Cliente apagado com sucesso.");
                                }
                            }
                }
                
                if(opcaoDeCliente == 3){
                            System.out.println("===================");
                            System.out.println("ALTERAR CLIENTES");
                            System.out.println("===================");
                            
                            System.out.println("Informe o código do cliente a ser alterado:");
                            clienteParaAlterar = teclado.nextInt();
                            
                            for(int i = 0; i < clienteCodigo.length; i++){
                                if(clienteParaAlterar == clienteCodigo[i]){
                                    System.out.print("Novo código: ");
                                    clienteCodigo[i] = teclado.nextInt();
                                    teclado.nextLine();
                                    
                                    System.out.print("Novo nome do Cliente: ");
                                    clienteNome[i] = teclado.nextLine();
                            
                                    System.out.print("Novo endereço: ");
                                    clienteEndereco[i] = teclado.nextLine();
                                
                                    System.out.print("Nova cidade: ");
                                    clienteCidade[i] = teclado.nextLine();
                            
                                    System.out.println(" ");
                                    System.out.println("Alteração concluída!");
                                }
                            }
                }
            }
            while(opcaoDeCliente != 0);
            break;
            
//==============================================================================      
            
            case 2:
                do{
                System.out.println("=========Menu de Opções de Produtos=========");
                System.out.println("1 - Inserir Produto");
                System.out.println("2 - Deletar Produto");
                System.out.println("3 - Alterar Produto");
                System.out.println("Digite Zero para voltar ao menu anterior");
                System.out.println("===================================");
                opcaoDeProduto = teclado.nextInt();
                
                if(opcaoDeProduto == 0){
                    break;
                }
                
                if(opcaoDeProduto == 1){
                    for(int i = 0; i < produtoCodigo.length; i++){
                        if(produtoCodigo[i] == 0){
                            System.out.println("===================");
                            System.out.println("CADASTRO DE PRODUTO");
                            System.out.println("===================");
                            
                            System.out.print("Código: ");
                            produtoCodigo[i] = teclado.nextInt();
                            teclado.nextLine();
                            
                            System.out.print("Descrição: ");
                            produtoDescricao[i] = teclado.nextLine();
                            
                            System.out.print("Valor: ");
                            produtoValor[i] = teclado.nextFloat();
                            
                            System.out.println("Produto cadastrado com sucesso.");
                            
                            contadorTotalDeProdutos++;
                            vetorCheio = false;
                            break;
                        }
                        
                        if(vetorCheio){
                            System.out.println("Não há como inserir o dado, espaço insuficiente.");
                        }
                    }
                }
                
                if(opcaoDeProduto == 2){
                    System.out.println("===================");
                    System.out.println("DELETAR PRODUTOS");
                    System.out.println("===================");
                            
                    System.out.println("Informe o código do produto:");
                    produtoParaDeletar = teclado.nextInt();
                            
                    for(int i = 0; i < clienteCodigo.length; i++){
                        if(produtoParaDeletar == produtoCodigo[i]){
                            produtoCodigo[i] = 0;
                            produtoDescricao[i] = "";
                            produtoValor[i] = 0.0f;
                            
                            contadorTotalDeProdutos--;
                            System.out.println("Produto apagado com sucesso.");
                            }
                    }
                }
                
                if(opcaoDeProduto == 3){
                    System.out.println("===================");
                    System.out.println("ALTERAR PRODUTOS");
                    System.out.println("===================");
                    
                    System.out.println("Informe o código do produto a ser alterado:");
                    produtoParaAlterar = teclado.nextInt();
                    
                    for(int i = 0; i < produtoCodigo.length; i++){
                        if(produtoParaAlterar == produtoCodigo[i]){
                            System.out.print("Novo código: ");
                            produtoCodigo[i] = teclado.nextInt();
                            teclado.nextLine();
                            
                            System.out.print("Nova descrição: ");
                            produtoDescricao[i] = teclado.nextLine();
                            
                            System.out.print("Novo valor: ");
                            produtoValor[i] = teclado.nextFloat();
                            
                            System.out.println(" ");
                            System.out.println("Alteração concluída!");
                        }
                    }
                }
                }
                while(opcaoDeProduto != 0);
            break;
            
//============================================================================== 
            
            case 3:
                for(int i = 0; i < refeicaoCodigo.length; i++){
                
                if(refeicaoCodigo[i] == 0){
                    System.out.println("===================");
                    System.out.println("CADASTRO DE VENDAS");
                    System.out.println("===================");
                    
                    System.out.print("Digite o código da refeição vendida: ");
                    refeicaoCodigo[i] = teclado.nextInt();
                    
                    System.out.print("Digite o código do cliente comprador: ");
                    refeicaoCliente[i] = teclado.nextInt();
                    
                    System.out.print("Digite o código do produto vendido: ");
                    refeicaoProduto[i] = teclado.nextInt();
                    
                    System.out.print("Digite a data da venda (modelo: DD/MM/AAAA): ");
                    refeicaoData[i] = teclado.next();
                    
                    System.out.println("Venda cadastrada!");
                    
                    contadorTotalDeVendas++;
                    vetorCheio = false;
                    break;
                }
                
                if(vetorCheio){
                    System.out.println("Não há como inserir o dado, espaço insuficiente.");
                    break;
                }
                }
            break;
            
//==============================================================================   
            
            case 4:
                System.out.println("===================");
                System.out.println("Listagem dos clientes cadastrados");
                System.out.println("===================");
                
                System.out.println("Deseja realmente imprimir o relatório? (S/N)");
                opcaoDeRelatorio = teclado.next().charAt(0);
                
                if(opcaoDeRelatorio == 'S' || opcaoDeRelatorio == 's'){
                    if(contadorTotalDeClientes == 0){
                        System.out.println("Não existem clientes cadastrados no sistema!");
                        break;
                    }
                    
                    for(int i = 0; i < clienteCodigo.length; i++){
                        if(clienteCodigo[i] != 0){
                            System.out.println("Cliente - Código: " + clienteCodigo[i] + 
                            " Nome: " + clienteNome[i] + " Endereço: " 
                            + clienteEndereco[i] + " Cidade: " + clienteCidade[i]);
                        }
                    }
                }
            break;
            
//==============================================================================     
            
            case 5:
                System.out.println("===================");
                System.out.println("Listagem dos produtos cadastrados");
                System.out.println("===================");
                
                System.out.println("Deseja realmente imprimir o relatório? (S/N)");
                opcaoDeRelatorio = teclado.next().charAt(0);
                
                if(opcaoDeRelatorio == 'S' || opcaoDeRelatorio == 's'){
                    if(contadorTotalDeProdutos == 0){
                        System.out.println("Não existem produtos cadastrados no sistema!");
                        break;
                    }
                    
                    for(int i = 0; i < produtoCodigo.length; i++){
                        if(produtoCodigo[i] != 0){
                            System.out.println("Produto - Código: " + produtoCodigo[i] + 
                            " Descrição: " + produtoDescricao[i] + " Valor: " 
                            + produtoValor[i]);
                        }
                    }
                }
            break;
            
//============================================================================== 
            
            case 6:
                System.out.println("===================");
                System.out.println("Listagem das vendas cadastradas");
                System.out.println("===================");
                
                System.out.println("Deseja realmente imprimir o relatório? (S/N)");
                opcaoDeRelatorio = teclado.next().charAt(0);
                
                if(opcaoDeRelatorio == 'N' || opcaoDeRelatorio == 'n'){
                    break;
                }
                
                if(opcaoDeRelatorio == 'S' || opcaoDeRelatorio == 's'){
                    if(contadorTotalDeVendas == 0){
                        System.out.println("Não existem vendas cadastradas no sistema!");
                        break;
                    }
                    
                    for(int i = 0; i < refeicaoCodigo.length; i++){
                        if(refeicaoCodigo[i] != 0){
                            System.out.println("Venda - Código: " + refeicaoCodigo[i] + 
                            " Cliente: " + refeicaoCliente[i] + " Produto: " 
                            + refeicaoProduto[i] + " Qtde: 1.0 Data: " + refeicaoData[i]);
                        }
                    }
                }
            break;
            
//==============================================================================       
            
            case 7:
                System.out.print("Digite o código do cliente para emitir a nota fiscal: ");
                codigo = teclado.nextInt();
                System.out.println(" ");
                

                
                for(int i = 0; i < clienteCodigo.length; i++){
                    
                    //CASO NÃO HAJA INFORMAÇÕES O SUFICIENTE:
                    if(codigo == clienteCodigo[i]){
                        if(clienteNome[i].equals("") || 
                        clienteEndereco[i].equals("") || clienteCidade[i].equals("")){
                        
                            System.out.println("Há dados que não foram "
                            + "preenchidos corretamente. Preencha-os e "
                            + "tente novamente.");
                            break;
                        }
                        
                        //INFORMAÇÕES SOBRE O CLIENTE
                        System.out.println("NOTA FISCAL");
                        System.out.println("===================");
                        System.out.print("Nome: " + clienteNome[i] + "\n");
                        System.out.print("Endereço: " + clienteEndereco[i] + "\n");
                        System.out.print("Cidade: " + clienteCidade[i] + "\n");
                        System.out.println("===================");
                        System.out.println("===Refeições===");
                        System.out.println("===================");
                    }
                }
                
                for(int i = 0; i < clienteCodigo.length; i++){
                    if(codigo == clienteCodigo[i]){
                    
                        for(int j = 0; j < refeicaoCodigo.length; j++){
                        
                            if(refeicaoCliente[j] == clienteCodigo[i]){ 
                            
                                for(int k = 0; k < produtoCodigo.length; k++){
                        
                                    if(produtoCodigo[k] == refeicaoProduto[j]){
                                        
                                        if(produtoDescricao[k].equals("") || produtoValor[k] == 0.0f){
                                            System.out.println("Hádados que não"
                                            + " foram preenchidos corretamente."
                                            + " Preencha-os e tente novamente.");
                                            break;
                                        }
                                        
                                        //INFORMAÇÕES SOBRE OS PRODUTOS COMPRADOS
                                        System.out.printf("Produto: %s      "
                                        + "Valor: %.2f\n", produtoDescricao[k], 
                                        produtoValor[k]);
                        
                                    }        
                            
                                }
                        
                            }
                    
                        }
                    
                    }
                
                }
                
                //TOTAL
                for(int a = 0; a < clienteCodigo.length; a++){
                    if(codigo == clienteCodigo[a]){
                    
                        for(int b = 0; b < refeicaoCodigo.length; b++){
                        
                            if(refeicaoCliente[b] == clienteCodigo[a]){ 
                            
                                for(int c = 0; c < produtoCodigo.length; c++){
                        
                                    if(produtoCodigo[c] == refeicaoProduto[b]){
                            
                                        total = total + produtoValor[c];
                            
                                    }
                        
                                }        
                            
                            }
                        
                        }
                    
                    }

                }
                System.out.println("=================");
                System.out.printf("Total: %.2f\n", total);
                System.out.println("=================");
            break;
            
//==============================================================================    
            
            case 8:
                System.out.println("===================");
                System.out.println("DELETAR BANCO DE DADOS");
                System.out.println("===================");
                
                System.out.println("Deseja realmente APAGAR todos os dados cadastrados? (S/N)");
                deletarBancoDeDados = teclado.next().charAt(0);
                
                if(deletarBancoDeDados == 'N' || deletarBancoDeDados == 'n'){
                    break;
                }
                
                if(deletarBancoDeDados == 'S' || deletarBancoDeDados == 's'){
                    for(int i = 0; i < clienteCodigo.length; i++){
                        clienteCodigo[i] = 0;
                        clienteNome[i] = "";
                        clienteEndereco[i] = "";
                        clienteCidade[i] = "";
                    }
                    
                    for(int i = 0; i < produtoCodigo.length; i++){
                        produtoCodigo[i] = 0;
                        produtoDescricao[i] = "";
                        produtoValor[i] = 0.0f;
                    }
                    
                    for(int i = 0; i < refeicaoCodigo.length; i++){
                        refeicaoCodigo[i] = 0;
                        refeicaoCliente[i] = 0;
                        refeicaoProduto[i] = 0;
                        refeicaoData[i] = "";
                    }
                    
                    System.out.println("Banco de dados deletado com sucesso.");
                }
            break;
            
//==============================================================================  
            
            case 9:
                if(contadorTotalDeVendas == 0){
                    System.out.println("Não existem vendas cadastradas.");
                    break;
                }
                
                System.out.println("===================");
                System.out.println("Relatório da maior refeição cadastrada do cliente");
                System.out.println("===================");
                
                System.out.println("Entre com o cliente: ");
                codigo = teclado.nextInt();
                
                for(int i = 0; i < clienteCodigo.length; i++){
                    if(codigo == clienteCodigo[i]){
                    
                        for(int j = 0; j < refeicaoCodigo.length; j++){
                        
                            if(refeicaoCliente[j] == clienteCodigo[i]){ 
                            
                                for(int k = 0; k < produtoCodigo.length; k++){
                        
                                    if(produtoCodigo[k] == refeicaoProduto[j]){
                            
                                        if(produtoValor[k] > maiorRefeicao){
                                
                                            maiorRefeicao = produtoValor[k];
                                            maiorProduto = produtoDescricao[k];
                            
                                        }
                        
                                    }        
                            
                                }
                        
                            }
                    
                        }
                    
                    }
                
                }
                
                System.out.printf("RELATÓRIO - REFEIÇÃO DE MAIOR VALOR: %s      "
                                + "Valor: R$%.2f", maiorProduto, maiorRefeicao);
                
            break;
            
//==============================================================================        
            
            case 10:
                if(contadorTotalDeVendas == 0){
                    System.out.println("Não existem vendas cadastradas.");
                    break;
                }
                
                System.out.println("===================");
                System.out.println("Relatório da menor refeição cadastrada do cliente");
                System.out.println("===================");
                
                System.out.println("Entre com o cliente: ");
                codigo = teclado.nextInt();
                
                for(int a = 0; a < clienteCodigo.length; a++){
                    if(codigo == clienteCodigo[a]){
                    
                        for(int b = 0; b < refeicaoCodigo.length; b++){
                        
                            if(refeicaoCliente[b] == clienteCodigo[a]){ 
                            
                                for(int c = 0; c < produtoCodigo.length; c++){
                        
                                    if(produtoCodigo[c] == refeicaoProduto[b]){
                            
                                        if(produtoValor[c] < menorRefeicao){
                                
                                            menorRefeicao = produtoValor[c];
                                            menorProduto = produtoDescricao[c];
                            
                                        }
                        
                                    }        
                            
                                }
                        
                            }
                    
                        }
                    
                    }
                
                }
                
                System.out.printf("RELATÓRIO - REFEIÇÃO DE MENOR VALOR: %s      "
                                + "Valor: R$%.2f", menorProduto, menorRefeicao);
            break;
//==============================================================================            
            case 11:
                
                if(contadorTotalDeVendas == 0){
                    System.out.println("Não existem vendas cadastradas.");
                    break;
                }
                
                System.out.println("===================");
                System.out.println("Relatório da menor refeição cadastrada do cliente");
                System.out.println("===================");
                
                System.out.println("Entre com o cliente: ");
                codigo = teclado.nextInt();
                
                for(int i = 0; i < clienteCodigo.length; i++){
                    if(codigo == clienteCodigo[i]){
                    
                        for(int ii = 0; ii < refeicaoCodigo.length; ii++){
                        
                            if(refeicaoCliente[ii] == clienteCodigo[i]){ 
                            
                                for(int iii = 0; iii < produtoCodigo.length; iii++){
                        
                                    if(produtoCodigo[iii] == refeicaoProduto[ii]){
                            
                                        total = total + produtoValor[iii];
                            
                                    }
                        
                                }        
                            
                            }
                        
                        }
                    
                    }
                    
                }
                System.out.printf("RELATÓRIO - TOTAL DAS REFEIÇÕES DO "
                                         + "CLIENTE É: R$%.2f\n", total);
            break;
        }
        }
        while(opcao != 0);
    }
}