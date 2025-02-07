import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente"));

        // Remove João
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // Exibe funcionários
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-20s\n", "Nome", "Data Nascimento", "Salário", "Função");
        System.out.println("---------------------------------------------------------------");
        for (Funcionario funcionario : funcionarios) {
            exibirFuncionarios(funcionario);
        }
        System.out.println("---------------------------------------------------------------");

        // Ajuste de salário
        for (Funcionario funcionario : funcionarios) {
            funcionario.ajustarSalario(new BigDecimal("10"));
        }

        // Exibe funcionários após ajuste
        System.out.println("-------------------- Valor após reajuste ----------------------");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-20s\n", "Nome", "Data Nascimento", "Salário", "Função");
        System.out.println("---------------------------------------------------------------");
        for (Funcionario funcionario : funcionarios) {
            exibirFuncionarios(funcionario);
        }
        System.out.println("---------------------------------------------------------------");

        // Agrupa funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Exibir funcionários agrupados por função
        System.out.println("----------------- Funcionários por função ---------------------");
        exibirFuncionariosAgrupados(funcionariosPorFuncao);

        // Exibir funcionários aniversariantes do mês 10 e 12
        exibirAniversariantes(funcionarios);

        // Exibir funcionário mais velho
        exibirFuncionarioMaisVelho(funcionarios);

        // Exibir funcionários por ordem alfabética
        exibirFuncionariosPorOrdemAlfabetica(funcionarios);

        // Exibir total de salário dos funcionários
        BigDecimal totalSalarios = calcularTotalSalarios(funcionarios);
        System.out.println("Total dos salários: " + totalSalarios);

        // Exibir total de salários minimos por funcionário
        imprimirSalariosMinimos(funcionarios);

    }

    public static void exibirFuncionarios(Funcionario funcionario) {
        System.out.printf("%-20s %-15s %-10s %-20s\n", funcionario.getNome(), formataData(funcionario), formataSalario(funcionario), funcionario.getFuncao());
    }

    public static String formataData(Funcionario funcionario) {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return funcionario.getDataNascimento().format(formatadorData);

    }

    public static String formataSalario(Funcionario funcionario) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.of("pt","BR"));
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat formatadorSalario = new DecimalFormat("#,###.00", simbolos);
        return formatadorSalario.format(funcionario.getSalario());
    }

    public static void exibirFuncionariosAgrupados(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            System.out.println("-----------------------------------------------");
            for(Funcionario funcionario : entry.getValue()) {
                System.out.printf("%-20s %-15s %-10s\n",
                        funcionario.getNome(),
                        formataData(funcionario),
                        formataSalario(funcionario)
                );
            }
            System.out.println();
        }
    }

    public static void exibirAniversariantes(List<Funcionario> funcionarios) {
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(funcionario -> {
                    int mesNascimento = funcionario.getDataNascimento().getMonthValue();
                    return mesNascimento == 10 || mesNascimento == 12;
                })
                .toList();
        System.out.println("Aniversariantes de Outubro/Dezembro: ");
        aniversariantes.forEach(funcionario -> System.out.println(" - " + funcionario.getNome() + " ( " + formataData(funcionario) + " )"));
    }

    public static void exibirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min((funcionarioA, funcionarioB) -> funcionarioA.getDataNascimento().compareTo(funcionarioB.getDataNascimento()))
                .orElseThrow(() -> new IllegalArgumentException("Nenhum funcionário encontrado"));

        int idade = calcularIdade(funcionarioMaisVelho);
        System.out.println("\n-----------------------------------------------");
        System.out.println("Funcionário mais velho: " + funcionarioMaisVelho.getNome() + " - " + idade + " anos de idade.");
    }

    public static int calcularIdade(Funcionario funcionario) {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(funcionario.getDataNascimento(), hoje);
        return idade.getYears();
    }

    public static void exibirFuncionariosPorOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.sort((funcionarioA, funcionarioB) -> funcionarioA.getNome().compareTo(funcionarioB.getNome()));

        System.out.println("\nFuncionários ordenados por nome: ");

        funcionarios.forEach(funcionario -> System.out.println("  - " + funcionario.getNome()));
    }

    public static BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        return totalSalarios;
    }

    public static void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("Funcionários e seus salários em salários mínimos:");

        for(Funcionario funcionario : funcionarios) {
            BigDecimal salarioMinimoFuncionario = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(" - " + funcionario.getNome() + " ganha " + salarioMinimoFuncionario + " salários mínimos.");
        }
    }

}

