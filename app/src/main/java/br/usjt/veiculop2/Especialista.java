package br.usjt.veiculop2;

/**
 * Created by asbonato on 9/5/15.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Veiculo> veiculos = cadastroDeVeiculos();

    public Especialista() {

    }

    private TreeSet<Veiculo> buscarModelo(String modelo) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (modelo.equals(veiculo.getModelo())) {
                lista.add(veiculo);
            }
        }
        return null;
    }

    public TreeSet<Veiculo> listarMarcas(String ano, String marca, String categoria) {
        TreeSet<Veiculo> marcas = new TreeSet<Veiculo>();

        if (ano.length() > 0 && marca.length() > 0 && categoria.length() > 0) {
            marcas = buscarAnoMarcaCategoria(ano, marca, categoria);
        } else if (ano.length() > 0 && marca.length() > 0) {
            marcas = buscarAnoMarca(ano, marca);
        } else if (ano.length() > 0 && categoria.length() > 0) {
            marcas = buscarAnoCategoria(ano, categoria);
        } else if (marca.length() > 0 && categoria.length() > 0) {
            marcas = buscarMarcaCategoria(marca, categoria);
        } else if (ano.length() > 0) {
            marcas = buscarAno(ano);
        } else if (marca.length() > 0) {
            marcas = buscarMarca(marca);
        } else if (categoria.length() > 0) {
            marcas = buscarCategoria(categoria);
        } else {
            marcas = todas();
        }

        return marcas;
    }

    private TreeSet<Veiculo> buscarAno(String ano) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (ano.equals(veiculo.getAno())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarMarca(String marca) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (marca.equals(veiculo.getMarca())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarCategoria(String categoria) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (categoria.equals(veiculo.getCategoria())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarAnoMarca(String ano, String marca) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (ano.equals(veiculo.getAno())
                    && marca.equals(veiculo.getMarca())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarAnoCategoria(String ano, String categoria) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (ano.equals(veiculo.getAno())
                    && categoria.equals(veiculo.getCategoria())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarMarcaCategoria(String marca, String categoria) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (marca.equals(veiculo.getMarca()) && categoria.equals(veiculo.getCategoria())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> buscarAnoMarcaCategoria(String ano, String marca,
                                                 String categoria) {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            if (ano.equals(veiculo.getAno())
                    && marca.equals(veiculo.getMarca())
                    && categoria.equals(veiculo.getCategoria())) {
                lista.add(veiculo);
            }
        }
        return lista;
    }

    private TreeSet<Veiculo> todas() {
        TreeSet<Veiculo> lista = new TreeSet<Veiculo>();
        for (Veiculo veiculo : veiculos) {
            lista.add(veiculo);
        }
        return lista;
    }

    private static ArrayList<Veiculo> cadastroDeVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        veiculos.add(new Veiculo("2015", "Palio",
                "Fiat", "A", "veiculo001", 22.99));

        veiculos.add(new Veiculo("2015", "Onix",
                "Chevrolet", "A", "veiculo002", 25.90));

        veiculos.add(new Veiculo("2014", "Strada",
                "Fiat", "B", "veiculo003", 22.99));

        veiculos.add(new Veiculo("2014", "HB20",
                "Hyundai", "C", "veiculo004", 27.00));

        veiculos.add(new Veiculo("2011", "Ka",
                "Ford", "A", "veiculo005", 21.50));

        veiculos.add(new Veiculo("2013", "Jetta",
                "Volkswagen", "C", "veiculo006", 29.99));

        veiculos.add(new Veiculo("2013", "Uno",
                "Fiat", "A", "veiculo007", 24.90));

        veiculos.add(new Veiculo("2011", "Sandero",
                "Renault", "A", "veiculo008", 28.00));

        veiculos.add(new Veiculo("2012", "Prisma",
                "Chevrolet", "B", "veiculo009", 23.40));

        veiculos.add(new Veiculo("2015", "Corolla",
                "Toyota", "C", "veiculo010", 27.99));

        return veiculos;
    }
}
