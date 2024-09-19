import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.timur.models.Point;
import ru.timur.utils.AreaValidator;

import static org.junit.jupiter.api.Assertions.*;

public class AreaCheckTest {

    @ParameterizedTest
    @CsvSource({
            "-1.0, -2.0, 3.0",  // Прямоугольник
            "-2.0, -4.0, 5.0"   // Прямоугольник
    })
    public void checkAreaOnRectangle(double x, double y, double r) {
        assertTrue(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 1.0, 2.0",   // Треугольник
            "1.0, 4.0, 5.0"    // Треугольник
    })
    public void checkAreaOnTriangle(double x, double y, double r) {
        assertTrue(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "-1.0, 1.0, 2.0",   // Круг
            "-3.0, 0.5, 4.0"    // Круг
    })
    public void checkAreaOnCircle(double x, double y, double r) {
        assertTrue(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @Test
    public void checkAreaOnEmpty() {
        assertTrue(AreaValidator.checkArea(new Point(0.0, 0.0, 2.0)));
    }

    // Параметризованные тесты для проверки некорректных данных

    @ParameterizedTest
    @CsvSource({
            "6.0, 0.0, 3.0",  // X выходит за пределы
            "0.0, 6.0, 3.0",  // Y выходит за пределы
            "0.0, 0.0, 0.5",  // R меньше минимального
            "0.0, 0.0, 6.0"   // R больше максимального
    })
    public void checkInvalidAreaOutOfBounds(double x, double y, double r) {
        assertFalse(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "Double.NaN, 1.0, 3.0",  // NaN в X
            "0.5, Double.NaN, 3.0",  // NaN в Y
            "0.5, 1.0, Double.NaN"   // NaN в R
    })
    public void checkNaNValues(double x, double y, double r) {
        assertFalse(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "Double.POSITIVE_INFINITY, 0.0, 3.0",  // Бесконечность в X
            "0.0, Double.NEGATIVE_INFINITY, 3.0",  // Бесконечность в Y
            "0.0, 0.0, Double.POSITIVE_INFINITY"   // Бесконечность в R
    })
    public void checkInfiniteValues(double x, double y, double r) {
        assertFalse(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "-2.0, -1.0, 2.0",  // Граница прямоугольника
            "0.0, 2.0, 2.0",    // Граница треугольника
            "-2.0, 0.0, 2.0"    // Граница круга
    })
    public void checkPointsOnBoundary(double x, double y, double r) {
        assertTrue(AreaValidator.checkArea(new Point(x, y, r)));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 1.0, -1.0",  // Отрицательный радиус
            "0.0, 0.0, 0.0"    // Нулевой радиус
    })
    public void checkInvalidRadius(double x, double y, double r) {
        assertFalse(AreaValidator.checkArea(new Point(x, y, r)));
    }
}
