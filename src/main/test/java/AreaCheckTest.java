import org.junit.Test;
import ru.timur.models.Point;
import ru.timur.utils.AreaValidator;

import static org.junit.Assert.*;

public class AreaCheckTest {

    @Test
    public void testAreaOnRectangle1() {
        // Прямоугольник
        assertTrue(AreaValidator.checkArea(new Point(-1.0, -2.0, 3.0)));
    }

    @Test
    public void testAreaOnRectangle2() {
        // Прямоугольник
        assertTrue(AreaValidator.checkArea(new Point(-2.0, -4.0, 5.0)));
    }

    @Test
    public void testAreaOnTriangle1() {
        // Треугольник
        assertTrue(AreaValidator.checkArea(new Point(1.0, 1.0, 2.0)));
    }

    @Test
    public void testAreaOnTriangle2() {
        // Треугольник
        assertTrue(AreaValidator.checkArea(new Point(1.0, 4.0, 5.0)));
    }

    @Test
    public void testAreaOnCircle1() {
        // Круг
        assertTrue(AreaValidator.checkArea(new Point(-1.0, 1.0, 2.0)));
    }

    @Test
    public void testAreaOnCircle2() {
        // Круг
        assertTrue(AreaValidator.checkArea(new Point(-3.0, 0.5, 4.0)));
    }

    @Test
    public void testAreaOnEmpty() {
        // Пустая область
        assertTrue(AreaValidator.checkArea(new Point(0.0, 0.0, 2.0)));
    }

    @Test
    public void testInvalidAreaOutOfBounds1() {
        // X выходит за пределы
        assertFalse(AreaValidator.checkArea(new Point(6.0, 0.0, 3.0)));
    }

    @Test
    public void testInvalidAreaOutOfBounds2() {
        // Y выходит за пределы
        assertFalse(AreaValidator.checkArea(new Point(0.0, 6.0, 3.0)));
    }

    @Test
    public void testInvalidAreaOutOfBounds3() {
        // R меньше минимального
        assertFalse(AreaValidator.checkArea(new Point(0.0, 0.0, 0.5)));
    }

    @Test
    public void testInvalidAreaOutOfBounds4() {
        // R больше максимального
        assertFalse(AreaValidator.checkArea(new Point(0.0, 0.0, 6.0)));
    }

    @Test
    public void testNaNValues1() {
        // NaN в X
        assertFalse(AreaValidator.checkArea(new Point(Double.NaN, 1.0, 3.0)));
    }

    @Test
    public void testNaNValues2() {
        // NaN в Y
        assertFalse(AreaValidator.checkArea(new Point(0.5, Double.NaN, 3.0)));
    }

    @Test
    public void testNaNValues3() {
        // NaN в R
        assertFalse(AreaValidator.checkArea(new Point(0.5, 1.0, Double.NaN)));
    }

    @Test
    public void testInfiniteValues1() {
        // Бесконечность в X
        assertFalse(AreaValidator.checkArea(new Point(Double.POSITIVE_INFINITY, 0.0, 3.0)));
    }

    @Test
    public void testInfiniteValues2() {
        // Бесконечность в Y
        assertFalse(AreaValidator.checkArea(new Point(0.0, Double.NEGATIVE_INFINITY, 3.0)));
    }

    @Test
    public void testInfiniteValues3() {
        // Бесконечность в R
        assertFalse(AreaValidator.checkArea(new Point(0.0, 0.0, Double.POSITIVE_INFINITY)));
    }

    @Test
    public void testPointsOnBoundary1() {
        // Граница прямоугольника
        assertTrue(AreaValidator.checkArea(new Point(-1.0, -2.0, 2.0)));
    }

    @Test
    public void testPointsOnBoundary2() {
        // Граница треугольника
        assertTrue(AreaValidator.checkArea(new Point(0.0, 2.0, 2.0)));
    }

    @Test
    public void testPointsOnBoundary3() {
        // Граница круга
        assertTrue(AreaValidator.checkArea(new Point(-2.0, 0.0, 2.0)));
    }

    @Test
    public void testInvalidRadius1() {
        // Отрицательный радиус
        assertFalse(AreaValidator.checkArea(new Point(1.0, 1.0, -1.0)));
    }

    @Test
    public void testInvalidRadius2() {
        // Нулевой радиус
        assertFalse(AreaValidator.checkArea(new Point(0.0, 0.0, 0.0)));
    }

//    @Test
//    public void testInvalidData() {
//        // Тест с некорректными данными
//        assertThrows(IllegalArgumentException.class, () -> {
//            AreaValidator.checkArea(new Point("invalid", "data", "values"));
//        });
//    }
}
