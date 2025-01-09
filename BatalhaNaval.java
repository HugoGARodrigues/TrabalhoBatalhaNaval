

public class BatalhaNaval{

    public static void main(String[] args){

        char[][] novocenario = gerarCenarioAleatorio();

        novocenario[2][2] = 'O';

        exibirCenario(novocenario, true);
    }
        


    public static char[][] gerarCenarioAleatorio(){
        char[][] cenario = new char[10][10];
        int contador = 0;
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                cenario[i][j] ='0';
            }
        }
        
        

        while (contador < 5){

            int randomint1= gerandoNumeroAleatorioInteiro(0,9);
            int randomint2= gerandoNumeroAleatorioInteiro(0,9);
            System.out.println(randomint1);
            System.out.println(randomint2);

            boolean testeposicao = varrerposicao(randomint1, randomint2, cenario, contador+1);
            if(testeposicao){
                System.out.println(randomint1);
                System.out.println(randomint2);
                //Embarcação horizontal = 0  vertical = 1
                int eixo = gerandoNumeroAleatorioInteiro(0, 1);
                if(eixo == 0){
                    for(int i = 0; i<contador+1; i++){
                        cenario[randomint1][i+randomint2] = transformandoIntemChar(contador+1);
                    }
                }else{
                    for(int i = 0; i<contador+1; i++){
                        cenario[randomint1+i][randomint2] = transformandoIntemChar(contador+1);
                    }
                }
                contador++;
            }else{
            }

        }

        return cenario;

        

    }

    public static boolean varrerposicao(int posicaox, int posicaoy, char[][] cenario, int tamanho){
        boolean valorfinal = false;
        int auxiliaFinal = 0;
        
        if(tamanho+posicaox > 10 || tamanho+posicaoy > 10){
            auxiliaFinal++;
        }else{
            for(int i = 0; i < tamanho; i++){
                if(cenario[posicaox][posicaoy+i]!='0' && cenario[posicaox + i][posicaoy]!='0'){
                    auxiliaFinal++;
                }

            }
            

        }
        if(auxiliaFinal == 0){
            valorfinal = true;
        }
        return valorfinal;

    }

    public static int gerandoNumeroAleatorioInteiro(int min, int max) {
            
            int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
            
            return numeroAleatorio;

    }

    public static char transformandoIntemChar(int numero){
        char caractere = (char) ('0' + numero);
        return caractere;

    }

    public static void exibirCenario(char[][] cenario, boolean ocultarEmbarcacoes){
        int contador = 1;
        for (int i = 0; i < cenario.length; i++) {
            for (int j = 0; j < cenario[i].length; j++) {
                if(ocultarEmbarcacoes && (cenario[i][j] == '0' || cenario[i][j] == '1' || cenario[i][j] == '2' || cenario[i][j] == '3' || cenario[i][j] == '4' || cenario[i][j] == '5')){
                    System.out.printf("%3s ",String.valueOf(contador) + " ");
                } else{
                    System.out.printf("%3s ", cenario[i][j] + " ");
                }
                contador++;
            }
            System.out.println();
        }

    }


    


    public static boolean realizarAtaque(char[][] cenarioAdversario, int linha, int coluna){
        if(cenarioAdversario[linha][coluna]!='0'){

            System.out.println("Bomba");
            return true;
        } else{
            System.out.println("Agua");
            return false;
        }

    }

    

    

    public static void atualizarCenario(char[][] cenario, int linha, int coluna, boolean acerto){
        if(acerto){
            cenario[linha][coluna] = 'X';
        } else{
            cenario[linha][coluna] = 'O';
        }

    }

    /*

    public static boolean verificarEmbarcacaoAfundada(char[][] cenario, int tamanhoEmbarcacao){

    }

    public static boolean verificarAtaqueRepetido(boolean[][] ataques, int linha, int coluna){

    }

    public static int contarEmbarcacoesAfundadas(char[][] cenario){

    }

    public static boolean verificarVitoria(char[][] cenario){

    }

    

    public static char[][] facilitadorTradutor(int posicao){

    }
    

}



*/





    

    
}

