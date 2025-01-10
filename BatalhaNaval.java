
import java.util.Scanner;



public class BatalhaNaval{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int running = 1;
        

        while (running == 1){
            boolean jogoTerminado = false;
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            int valorDeEntrada = scanner.nextInt();
            if (valorDeEntrada == 1){
                System.out.println("Este jogo de batalha naval é para 2 jogares, os tiros serao alternados e iniciaram com os tiros do primeiro jogador");
                System.out.println("O campo de batalhas terá números para indicar as posiçoes para o ataque");
                System.out.println("Vao haver 5 embarcações de tamanho de 1 a 5, ganha quem afundar todas primeiro");
                char[][] cenarioJogador1 = gerarCenarioAleatorio();
                char[][] cenarioJogador2 = gerarCenarioAleatorio();

                while(true){


                    System.out.println("-------------------------------------------------------------------------------------------------");
                   
                    Jogador1(cenarioJogador2);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioJogador2))){
                        System.out.println("Jogador 1 ganhou!");
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogador2(cenarioJogador1);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioJogador1))){
                        
                        System.out.println("Jogador 2 ganhou!");
                        break;
                    }

                    

            
                
            
            
                }
            }else if(valorDeEntrada == 2){
                running = 2;

            }
        }
    }
        

    public static void Jogador1(char[][] cenarioJogador2) {
        Scanner scanner = new Scanner(System.in);
        boolean running = false;
        char auxiliar;

       

        while(running == false){

            System.out.println("Jogador 1");
            System.out.println("Veja o campo do seu inimigo:");
            exibirCenario(cenarioJogador2, true);
            System.out.println("Jogador 1 indique a posicao que voce deseja atacar");
            int ataqueJogador1 = scanner.nextInt();

            if(verificarAtaqueRepetido(cenarioJogador2, ataqueJogador1) == true){
                System.out.println("Ataque já realizado nessa posicao. Tente outra.");
                running = false;
            }else{
                boolean acertou = realizarAtaque(cenarioJogador2, ataqueJogador1);
                if(acertou == true){
                    auxiliar = cenarioJogador2[tradutorLinha(ataqueJogador1)][tradutorColuna(ataqueJogador1)];
                    atualizarCenario(cenarioJogador2, ataqueJogador1, acertou);
                    verificarEmbarcacaoAfundada(cenarioJogador2, auxiliar);
                    running = true;
                }else{
                    atualizarCenario(cenarioJogador2, ataqueJogador1, acertou);
                    running = true;
                }
            }
            
        }
        

        

    }

    public static void Jogador2(char[][] cenarioJogador1) {
        Scanner scanner = new Scanner(System.in);
        boolean running = false;
        char auxiliar;

        while(running == false){
            System.out.println("Jogador 2");
            System.out.println("Veja o campo do seu inimigo:");
            exibirCenario(cenarioJogador1, true);
            System.out.println("Jogador 2 indique a posicao que voce deseja atacar");
            int ataqueJogador2 = scanner.nextInt();

            if(verificarAtaqueRepetido(cenarioJogador1, ataqueJogador2) == true){
                System.out.println("Ataque já realizado nessa posicao. Tente outra.");
                running = false;
            }else{
                boolean acertou = realizarAtaque(cenarioJogador1, ataqueJogador2);
                if(acertou == true){
                    auxiliar = cenarioJogador1[tradutorLinha(ataqueJogador2)][tradutorColuna(ataqueJogador2)];
                    atualizarCenario(cenarioJogador1, ataqueJogador2, acertou);
                    verificarEmbarcacaoAfundada(cenarioJogador1, auxiliar);
                    running = true;
                }else{
                    atualizarCenario(cenarioJogador1, ataqueJogador2, acertou);
                    running = true;
            }
            }
            
        }

        

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

            boolean testeposicao = varrerPosicao(randomint1, randomint2, cenario, contador+1);
            if(testeposicao){
                
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
                if(cenario[posicaox][posicaoy+i]!='0' || cenario[posicaox + i][posicaoy]!='0'){
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


    


    public static boolean realizarAtaque(char[][] cenarioAdversario, int posicao){
        if(cenarioAdversario[tradutorLinha(posicao)][tradutorColuna(posicao)] !='0'){

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
            cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] = '~';
        }

    }

    

    public static void verificarEmbarcacaoAfundada(char[][] cenario, char caracter){

            int contador = 0;
            

            if(caracter == '1'){
                System.out.println("Você a afundou a embarcacao de tamanho 1");
                

            }else if(caracter == '2'){
                for(int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(cenario[i][j] == '2'){
                            contador++;
                        }

                    }
                }
                
                if(contador == 0){
                    System.out.println("Você a afundou a embarcacao de tamanho 2");
                }
            }else if(caracter == '3'){
                for(int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(cenario[i][j] == '3'){
                            contador++;
                        }

                    }
                }
                
                if(contador == 0){
                    System.out.println("Você a afundou a embarcacao de tamanho 3");
                }

            }else if(caracter == '4'){
                for(int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(cenario[i][j] == '4'){
                            contador++;
                        }

                    }
                }
                
                if(contador == 0){
                    System.out.println("Você a afundou a embarcacao de tamanho 4");
                }

            }else if(caracter == '5'){
                for(int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(cenario[i][j] == '5'){
                            contador++;
                        }

                    }
                }
                
                if(contador == 0){
                    System.out.println("Você a afundou a embarcacao de tamanho 5");
        
                }

            }else{
                System.out.println("Você ainda não afundou essa embarcação");
            }

            
        

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

        if(cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] == 'X' || cenario[tradutorLinha(posicao)][tradutorColuna(posicao)] == '~'){
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

        
        if(contadorAuxiliar1 == 0 && contadorAuxiliar2 == 0 && contadorAuxiliar3 == 0 && contadorAuxiliar4 == 0 && contadorAuxiliar5 == 0){
            contadorAfundadas += 5;
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








    

    


