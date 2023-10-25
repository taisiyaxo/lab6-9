package lab9;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    //для Function
    public static <T, R> R getFunctionRes(Function<T,R> function, T item){
        return function.apply(item);
    }
    //для Predicate
    public static <T> boolean getPredicateRes(Predicate<T> predicate, T item){
        return predicate.test(item);
    }
    //для BiPredicate
    public static <T> boolean getBiPredicateRes(BiPredicate<T, T> predicate, T item1, T item2){
        return predicate.test(item1, item2);
    }
    //для LambdaDemoInter
    public static boolean getLambdaDemoInterRes(LambdaDemoInter ldi, Human h1, Human h2, Human h3, int maxAge){
        return ldi.check(h1, h2, h3, maxAge);
    }
}

