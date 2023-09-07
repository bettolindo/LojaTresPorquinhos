
import java.util.Random;

public class LojaDosTresPorquinhos {
    public static void main(String[] args) {
        // Definindo os nomes e códigos dos produtos
        String[] nomesProdutos = {"Tijolo", "Palha", "Madeira", "Cimento", "Areia", "Brita", "Porta"};
        int[] codigoProdutos = {1, 2, 3, 4, 5, 6, 7};

        // Definindo o tamanho do mapa de estoque (ruas x prateleiras)
        int ruas = 14;
        int prateleiras = 10;

        // Gerando o mapa de estoque com números aleatórios
        int[][] estoque = gerarEstoqueAleatorio(ruas, prateleiras);

        // Imprimindo a matriz completa do estoque
        imprimirMatriz(estoque);

        // Inicializando o array para armazenar o total de cada código de produto
        int[] totalPorCodigo = new int[8];

        // Calculando o total de cada código de produto no estoque
        for (int i = 0; i < ruas; i++) {
            for (int j = 0; j < prateleiras; j++) {
                int codigoProduto = estoque[i][j] / 100; 
                int quantidade = estoque[i][j] % 100; 

                totalPorCodigo[codigoProduto] += quantidade;
            }
        }

        // Imprimindo o relatório final
        System.out.println("------------------------------------------------");
        System.out.println("--- Loja - O Lobo Feroz - Inventário do Estoque");
        System.out.println("------------------------------------------------");

        for (int i = 1; i <= 7; i++) {
            System.out.println(nomesProdutos[i - 1] + "\t" + totalPorCodigo[i]);
        }

        // Encontrando o código e nome do produto com maior e menor estoque
        int codigoMaiorEstoque = 1;
        int maiorEstoque = totalPorCodigo[1];
        int codigoMenorEstoque = 1;
        int menorEstoque = totalPorCodigo[1];

        for (int i = 2; i <= 7; i++) {
            if (totalPorCodigo[i] > maiorEstoque) {
                maiorEstoque = totalPorCodigo[i];
                codigoMaiorEstoque = i;
            }
            if (totalPorCodigo[i] < menorEstoque) {
                menorEstoque = totalPorCodigo[i];
                codigoMenorEstoque = i;
            }
        }
        System.out.println("\nProduto com Maior Estoque: Código " + codigoMaiorEstoque + " - " + nomesProdutos[codigoMaiorEstoque - 1]);
        System.out.println("Produto com Menor Estoque: Código " + codigoMenorEstoque + " - " + nomesProdutos[codigoMenorEstoque - 1]);
    }

    // Função para gerar o mapa de estoque com números aleatórios
    public static int[][] gerarEstoqueAleatorio(int ruas, int prateleiras) {
        int[][] estoque = new int[ruas][prateleiras];
        Random random = new Random();

        for (int i = 0; i < ruas; i++) {
            for (int j = 0; j < prateleiras; j++) {
                int codigoProduto = random.nextInt(7) + 1;
                int quantidade = random.nextInt(100); // Alterado para gerar de 0 a 99
                estoque[i][j] = codigoProduto * 100 + quantidade;
            }
        }
        return estoque;
    }

    // Função para imprimir uma matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
