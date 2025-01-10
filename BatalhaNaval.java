
import java.util.Scanner;



public class BatalhaNaval{

    public static void main(String[] args){

        char[][] novocenario = gerarCenarioAleatorio();

        novocenario[2][2] = 'O';

        exibirCenario(novocenario, true);
        Scanner scanner = new Scanner(System.in);

        int valorDeEntrada = scanner.nextInt();

        System.out.printf("(%d,%d)", tradutorLinha(valorDeEntrada), tradutorColuna(valorDeEntrada));
        System.out.println(contarEmbarcacoesAfundadas(novocenario));
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

            boolean testeposicao = varrerPosicao(randomint1, randomint2, cenario, contador+1);
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

    public static boolean varrerPosicao(int posicaox, int posicaoy, char[][] cenario, int tamanho){
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

    

    

    public static void atualizarCenario(char[][] cenario, int posicao, boolean acerto){
        
        
        if(acerto){
            cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] = 'X';
        } else{
            cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] = 'O';
        }

    }

    

    public static boolean verificarEmbarcacaoAfundada(char[][] cenario, int posicao, char tamanho){

        return true;

    }

    
    public static int tradutorLinha(int posicao) {

        int valorFinal = 0;
        double auxiliar = (double) posicao;
        
        if(posicao <= 10){

            valorFinal = 0;

        }else if(posicao > 10 && posicao < 100){
            if(posicao%10 == 0){
                valorFinal = posicao / 10 - 1;
            }else{

                
                auxiliar = posicao / 10;
                valorFinal = (int) Math.floor(auxiliar);

            }
            
        }else{
            valorFinal = 9;
        }


        return valorFinal;
        
        
    }

    public static int tradutorColuna(int posicao) {

        int valorFinal = 0;
        if(posicao <= 10){
            valorFinal = posicao - 1;

        }else if(posicao > 10 && posicao <= 100){
            if(posicao%10 == 0){
                valorFinal = 9;
            } else{
                valorFinal = posicao % 10 - 1;
            }
        }
        
        return valorFinal;
        
    }

    
 
    public static boolean verificarAtaqueRepetido(char[][] cenario, int posicao){

        if(cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] == 'X' || cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] == 'O'){
            return true;
        }else{
            return false;
        }

    }

    

    public static int contarEmbarcacoesAfundadas(char[][] cenario){

        int contadorAfundadas = 0;
        double contadorAuxiliar1 = 0;
        double contadorAuxiliar2 = 0;
        double contadorAuxiliar3 = 0;
        double contadorAuxiliar4 = 0;
        double contadorAuxiliar5 = 0;
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                
                if(cenario[i][j] == '1'){
                    contadorAuxiliar1++;
                }else if(cenario[i][j] == '2'){
                    contadorAuxiliar2++;
                }else if(cenario[i][j] == '3'){
                    contadorAuxiliar3++;
                }else if(cenario[i][j] == '4'){
                    contadorAuxiliar4++;
                }else if(cenario[i][j] == '5'){
                    contadorAuxiliar5++;
                }
            
            
            }
        }

        
        if(contadorAuxiliar1 == 0){
            contadorAfundadas++;
        }else if(contadorAuxiliar2 == 0){
            contadorAfundadas++;
        }else if(contadorAuxiliar3 == 0){
            contadorAfundadas++;
        } else if(contadorAuxiliar4 == 0){
            contadorAfundadas++;
        } else if(contadorAuxiliar5 == 0){
            contadorAfundadas++;
        }

        return contadorAfundadas;

    }

    
    public static boolean verificarVitoria(int numeroAfundadas){

        if (numeroAfundadas == 5){
            return true;
        }
        return false;

    }

    

    

}








    

    


