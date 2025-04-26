import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarListRepository carList;

    private Car car;

    @Before
    public void setUp() {
        carList = new CarListRepositoryImpl();
        car = new Car("Toyota", "John", 10);
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, "Owner" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Toyota", "John", 10);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("Toyota", "John", 10);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Toyota", "John", 10);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("Toyota", carFromList.getBrand());
    }
}