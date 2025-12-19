package skyshineb.aoc.y2025.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;

public class Runner {
    private final InputLoader inputLoader;

    public Runner(InputLoader inputLoader) {
        this.inputLoader = Objects.requireNonNull(inputLoader);
    }

    public List<RunResult> runAll() {
        List<SolverWithMeta> solvers = loadSolvers();

        solvers.sort(Comparator.comparingInt(s -> s.day));
        List<RunResult> results = new ArrayList<>(solvers.size());

        for (SolverWithMeta s : solvers) {
            Input input = inputLoader.readFile(s.inputPath);

            String p1 = s.solver.solveP1(input);
            String p2 = s.solver.solveP2(input);

            results.add(new RunResult(s.day, s.inputPath, p1, p2));
        }

        return results;
    }

    private List<SolverWithMeta> loadSolvers() {
        ServiceLoader<ProblemSolver> loader = ServiceLoader.load(ProblemSolver.class);

        List<SolverWithMeta> solvers = new ArrayList<>();
        for (ProblemSolver solver : loader) {
            AoCDay meta = solver.getClass().getAnnotation(AoCDay.class);
            solvers.add(new SolverWithMeta(meta.day(), meta.inputFile(), solver));
        }

        return solvers;
    }

    private record SolverWithMeta(int day, String inputPath, ProblemSolver solver) {}
}
