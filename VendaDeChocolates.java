import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendaDeChocolates {
    private List<Chocolate> chocolates;
    private List<Venda> vendas;

    public VendaDeChocolates() {
        this.chocolates = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void adicionarChocolate(Chocolate chocolate) {
        this.chocolates.add(chocolate);
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public List<Chocolate> listarChocolates() {
        return this.chocolates;
    }

    public List<Venda> listarVendas() {
        return this.vendas;
    }

    public double getTotalDeVendas() {
        double total = 0;
        for (Venda venda : this.vendas) {
            total += venda.getQuantidade() * venda.getChocolate().getPreco();
        }
        return total;
    }

    public static void main(String[] args) {
        int escolhaMarca = 0;
        VendaDeChocolates vendaDeChocolates = new VendaDeChocolates();

        Scanner scanner = new Scanner(System.in);

        // adicionar novos chocolates
        Chocolate chocolate1 = new Chocolate();
        chocolate1.setMarca("Nestle");
        chocolate1.setModelo("Alpino 337g");
        chocolate1.setPreco(12.0);
        vendaDeChocolates.adicionarChocolate(chocolate1);

        Chocolate chocolate2 = new Chocolate();
        chocolate2.setMarca("Nestle");
        chocolate2.setModelo("Classic 185g");
        chocolate2.setPreco(8.0);
        vendaDeChocolates.adicionarChocolate(chocolate2);

        Chocolate chocolate3 = new Chocolate();
        chocolate3.setMarca("Nestle");
        chocolate3.setModelo("Kit Kat 227g");
        chocolate3.setPreco(10.0);
        vendaDeChocolates.adicionarChocolate(chocolate3);

        Chocolate chocolate4 = new Chocolate();
        chocolate4.setMarca("Garoto");
        chocolate4.setModelo("Crocante 215g");
        chocolate4.setPreco(6.0);
        vendaDeChocolates.adicionarChocolate(chocolate4);

        Chocolate chocolate5 = new Chocolate();
        chocolate5.setMarca("Garoto");
        chocolate5.setModelo("Talento 350g");
        chocolate5.setPreco(15.0);
        vendaDeChocolates.adicionarChocolate(chocolate5);

        Chocolate chocolate6 = new Chocolate();
        chocolate6.setMarca("Garoto");
        chocolate6.setModelo("Baton ao leite 172g");
        chocolate6.setPreco(5.0);
        vendaDeChocolates.adicionarChocolate(chocolate6);

        Chocolate chocolate7 = new Chocolate();
        chocolate7.setMarca("Lacta");
        chocolate7.setModelo("A leite 170g");
        chocolate7.setPreco(4.0);
        vendaDeChocolates.adicionarChocolate(chocolate7);

        Chocolate chocolate8 = new Chocolate();
        chocolate8.setMarca("Lacta");
        chocolate8.setModelo("Oreo 257g");
        chocolate8.setPreco(6.0);
        vendaDeChocolates.adicionarChocolate(chocolate8);

        Chocolate chocolate9 = new Chocolate();
        chocolate9.setMarca("Lacta");
        chocolate9.setModelo("Sonho de Valsa 277g");
        chocolate9.setPreco(8.0);
        vendaDeChocolates.adicionarChocolate(chocolate9);

        // realizar vendas
        while (true) {
            System.out.println("Selecione o chocolate que deseja comprar:");
            List<Chocolate> chocolates = vendaDeChocolates.listarChocolates();
            for (int i = 0; i < chocolates.size(); i++) {
                Chocolate chocolate = chocolates.get(i);
                System.out.printf("%d - %s %s - R$ %.2f\n", i + 1, chocolate.getMarca(), chocolate.getModelo(),
                        chocolate.getPreco());
            }
            int escolha = scanner.nextInt();
            if (escolha < 1 || escolha > chocolates.size()) {
                System.out.println("Escolha inválida.");
                continue;
            }
            Chocolate chocolateEscolhido = chocolates.get(escolha - 1);

            System.out.println("Quantidade desejada:");
            int quantidade = scanner.nextInt();

            Venda venda = new Venda();
            venda.setChocolate(chocolateEscolhido);
            venda.setQuantidade(quantidade);
            vendaDeChocolates.adicionarVenda(venda);

            System.out.printf("%d %s %s adicionado(s) ao carrinho.\n", quantidade, chocolateEscolhido.getMarca(),
                    chocolateEscolhido.getModelo());

            System.out.println("Deseja continuar comprando? (s/n)");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        // mostrar carrinho de compras
        List<Venda> vendas = vendaDeChocolates.listarVendas();
        if (vendas.isEmpty()) {
            System.out.println("Nenhum item no carrinho.");
        } else {
            System.out.println("Carrinho de compras:");
            for (Venda venda : vendas) {
                System.out.printf("%d %s %s - R$ %.2f\n", venda.getQuantidade(), venda.getChocolate().getMarca(),
                        venda.getChocolate().getModelo(), venda.getQuantidade() * venda.getChocolate().getPreco());
            }
            System.out.printf("Total: R$ %.2f\n", vendaDeChocolates.getTotalDeVendas());
        }
    }
}

class Chocolate {
    private String marca;
    private String modelo;
    private double preco;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

class Venda {
    private Chocolate chocolate;
    private int quantidade;

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}