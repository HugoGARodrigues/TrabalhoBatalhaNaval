


import java.util.Scanner;



public class BatalhaNaval{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int running = 1;
        

        while (running == 1){
            System.out.println("Bem vindo ao jogo Batalha Naval, escolha o que você quer fazer");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            int valorDeEntrada = scanner.nextInt();
            while(valorDeEntrada >2 || valorDeEntrada < 1){
                System.out.println("Valor invalido, por favor insira um numero entre 1 e 2");
                valorDeEntrada = scanner.nextInt();
            }
            if (valorDeEntrada == 1){
                System.out.println("Insira a quantidade de jogadores (de 1 a 4 jogadores):");
                int numeroDeJogadores = scanner.nextInt();
                while(numeroDeJogadores < 1 || numeroDeJogadores>4){
                    System.out.println("Valor invalido, por favor insira um numero entre 1 e 4");
                    numeroDeJogadores = scanner.nextInt();
                }

                rodarJogoPara(numeroDeJogadores);
                
                

            
                
            
            
                }else if(valorDeEntrada == 2){
                running = 2;

            }
        }
        
        }
    

    public static void rodarJogoPara(int numeroDeJogadores){


        if (numeroDeJogadores == 1){

            System.out.println("Voce escolheu o jogo para uma pessoa apenas");
            System.out.println("O campo de batalhas terá números para indicar as posiçoes para o ataque");
            System.out.println("Haverao 5 embarcações de tamanho de 1 a 5, voce vence assim que afundar todas");
                char[][] cenarioAtaqueJogador1 = gerarCenarioAleatorio();

                while(true){


                    System.out.println("-------------------------------------------------------------------------------------------------");
                   
                    Jogando(cenarioAtaqueJogador1, 1);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador1))){
                        System.out.println("Jogador 1 ganhou!");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        break;
                    }
                }

        }else if(numeroDeJogadores == 2){
            System.out.println("Voce escolheu o jogo para duas pessoa apenas.");
            System.out.println("Vocês atacarao alternadamente");
            System.out.println("O campo de batalhas terá números para indicar as posiçoes para o ataque");
            System.out.println("Haverao 5 embarcações em cada cenário de tamanho de 1 a 5, ganha quem afundar todas primeiro");
                char[][] cenarioAtaqueJogador1 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador2 = gerarCenarioAleatorio();

                while(true){


                    System.out.println("-------------------------------------------------------------------------------------------------");
                   
                    Jogando(cenarioAtaqueJogador1, 1);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador1))){
                        System.out.println("Jogador 1 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador2, 2);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador2))){
                        System.out.println("Jogador 2 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        break;
                    }
                }
        }else if(numeroDeJogadores == 3){
            System.out.println("Voce escolheu o jogo para tres pessoa apenas.");
            System.out.println("Vocês atacarao alternadamente");
            System.out.println("O campo de batalhas terá números para indicar as posiçoes para o ataque");
            System.out.println("Haverao embarcações em cada cenário de tamanho de 1 a 5, ganha quem afundar todas primeiro");
                char[][] cenarioAtaqueJogador1 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador2 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador3 = gerarCenarioAleatorio();

                while(true){


                    System.out.println("-------------------------------------------------------------------------------------------------");
                   
                    Jogando(cenarioAtaqueJogador1, 1);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador1))){
                        System.out.println("Jogador 1 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador2, 2);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador2))){
                        System.out.println("Jogador 2 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador3, 3);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador3))){
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        System.out.println("Jogador 3 ganhou!");
                        break;
                    }
                }
            
        }else if(numeroDeJogadores == 4){
            System.out.println("Voce escolheu o jogo para quatro pessoa apenas.");
            System.out.println("Vocês atacarao alternadamente");
            System.out.println("O campo de batalhas terá números para indicar as posiçoes para o ataque");
            System.out.println("Haverao 5 embarcações em cada cenário de tamanho de 1 a 5, ganha quem afundar todas primeiro");
                char[][] cenarioAtaqueJogador1 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador2 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador3 = gerarCenarioAleatorio();
                char[][] cenarioAtaqueJogador4 = gerarCenarioAleatorio();

                while(true){


                    System.out.println("-------------------------------------------------------------------------------------------------");
                   
                    Jogando(cenarioAtaqueJogador1, 1);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador1))){
                        System.out.println("Jogador 1 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        System.out.println("Cenario final Jogador 4");
                        exibirCenarioFinal(cenarioAtaqueJogador4);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador2, 2);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador2))){
                        System.out.println("Jogador 2 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        System.out.println("Cenario final Jogador 4");
                        exibirCenarioFinal(cenarioAtaqueJogador4);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador3, 3);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador3))){
                        System.out.println("Jogador 3 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        System.out.println("Cenario final Jogador 4");
                        exibirCenarioFinal(cenarioAtaqueJogador4);
                        break;
                    }

                    System.out.println("------------------------------------------------------------------------------------------------");
                    
                    Jogando(cenarioAtaqueJogador4, 4);
                    if(verificarVitoria(contarEmbarcacoesAfundadas(cenarioAtaqueJogador4))){
                        System.out.println("Jogador 4 ganhou!");
                        System.out.println("Cenario final Jogador 1");
                        exibirCenarioFinal(cenarioAtaqueJogador1);
                        System.out.println("Cenario final Jogador 2");
                        exibirCenarioFinal(cenarioAtaqueJogador2);
                        System.out.println("Cenario final Jogador 3");
                        exibirCenarioFinal(cenarioAtaqueJogador3);
                        System.out.println("Cenario final Jogador 4");
                        exibirCenarioFinal(cenarioAtaqueJogador4);
                        break;
                    }
                }
        }


    }
        

    public static void Jogando(char[][] cenarioAtacar, int numeroDoJogador) {
        Scanner scanner = new Scanner(System.in);
        boolean running = false;
        char auxiliar;

       

        while(running == false){

            System.out.printf("Jogador %d\n", numeroDoJogador);
            System.out.println("Veja o campo do seu inimigo:");
            exibirCenario(cenarioAtacar, false);
            System.out.printf("Jogador %d indique a posicao que voce deseja atacar\n", numeroDoJogador);
            int ataqueJogador = scanner.nextInt();

            while(ataqueJogador <=0 || ataqueJogador > 100){
                System.out.println("Posicao invalida. Tente novamente.");
                ataqueJogador = scanner.nextInt();
            }

            if(verificarAtaqueRepetido(cenarioAtacar, ataqueJogador) == true){
                System.out.println("Ataque já realizado nessa posicao. Tente outra.");
                running = false;
            }else{
                boolean acertou = realizarAtaque(cenarioAtacar, ataqueJogador);
                if(acertou == true){
                    auxiliar = cenarioAtacar[tradutorLinha(ataqueJogador)][tradutorColuna(ataqueJogador)];
                    atualizarCenario(cenarioAtacar, ataqueJogador, acertou);
                    verificarEmbarcacaoAfundada(cenarioAtacar, auxiliar);
                    running = true;
                }else{
                    atualizarCenario(cenarioAtacar, ataqueJogador, acertou);
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

    public static void exibirCenarioFinal(char[][] cenarioFinal){
        System.out.println("Cenario Final:");

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(cenarioFinal[i][j] == '0'){
                    cenarioFinal[i][j] = '~';
                }
            }
        }
        
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.printf("%3s ", cenarioFinal[i][j]);
                
            }
            System.out.println();
        }
        
    }

    

    

}








    

    


