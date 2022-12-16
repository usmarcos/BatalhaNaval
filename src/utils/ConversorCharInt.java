package utils;

public class ConversorCharInt {

        public static char converter(char linha) {

            //converte a coluna char para um INT para validar as posições da matriz
            switch (linha) {
                case 'A':
                    linha = (int) 0;
                    break;
                case 'B':
                    linha = (int) 1;
                    break;
                case 'C':
                    linha = (int) 2;
                    break;
                case 'D':
                    linha = (int) 3;
                    break;
                case 'E':
                    linha = (int) 4;
                    break;
                case 'F':
                    linha = (int) 5;
                    break;
                case 'G':
                    linha = (int) 6;
                    break;
                case 'H':
                    linha = (int) 7;
                    break;
                case 'I':
                    linha = (int) 8;
                    break;
                case 'J':
                    linha = (int) 9;
                    break;
            }
        return linha;

    }
}
