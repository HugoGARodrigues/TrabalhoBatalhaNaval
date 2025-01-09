import java.util.Scanner;
import java.util.random.*;


public class BatalhaNaval{

    public static void main(String[] args){
        
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

            int randomint1= (int) Math.random()*10;
            int randomint2= (int) Math.random()*10;

            boolean testeposicao = varrerposicao(randomint1, randomint2, cenario, contador+1);
            if(testeposicao){
                //preencher cenario
                contador++;
            }

        }

        

    }

    public static void exibirCenario(char[][] cenario, boolean ocultarEmbarcacoes){

    }

    public static boolean realizarAtaque(char[][] cenarioAdversario, int linha, int coluna){

    }

    public static boolean verificarEmbarcacaoAfundada(char[][] cenario, int tamanhoEmbarcacao){

    }

    public static void atualizarCenario(char[][] cenario, int linha, int coluna, boolean acerto){

    }

    public static boolean verificarAtaqueRepetido(boolean[][] ataques, int linha, int coluna){

    }

    public static int contarEmbarcacoesAfundadas(char[][] cenario){

    }

    public static boolean verificarVitoria(char[][] cenario){

    }

    public static boolean varrerposicao(int posicaox1, int posicaoy, char[][] cenario, int tamanho){

        for(int i = 0; i < tamanho; i++){
            if(cenario[posicaox1][posicaoy+i]!='0'){
                return false;
            }
        }

    }

    

}








for(int i = 0; i < 5; i++){
    do {
        randomint1= (int) Math.random()*10;
        randomint2= (int) Math.random()*10;
    } while (cenario[randomint1][randomint2] != '0' && cenario[randomint1][randomint2+i] != '0' && cenario[randomint1+i][randomint2] != '0');
    

    
}

return cenario;