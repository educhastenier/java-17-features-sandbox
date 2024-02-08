package org.bonitasoft.watch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Java17TechWatchTest {

    @Test
    void howFarFromWednesdayAreWe() {
        Java17TechWatch java17TechWatch = new Java17TechWatch();
        assertEquals("Two days till Wednesday!", java17TechWatch.howFarFromWednesdayAreWe(DayOfWeek.MONDAY));
        assertEquals("One day till Wednesday!", java17TechWatch.howFarFromWednesdayAreWe(DayOfWeek.TUESDAY));
        assertEquals("It is Wednesday my dudes!", java17TechWatch.howFarFromWednesdayAreWe(DayOfWeek.WEDNESDAY));
        assertEquals("", java17TechWatch.howFarFromWednesdayAreWe(DayOfWeek.THURSDAY));
    }

    @Test
    void newNPE_should_be_more_descriptive() {
        Car car = new Car();
        try {
            car.getEngineDetails().getHorsePower();
            fail("Should have thrown a NPE");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining(".getEngineDetails()\" is null");
        }
    }

    @Test
    void records_auto_creates_standard_methods() {
        Bicycle bicycle1 = new Bicycle("red", "20");
        Bicycle bicycle2 = new Bicycle("red", "20");
        assertThat(bicycle1).isEqualTo(bicycle2); // equals is auto-generated
        assertThat(bicycle1.hashCode()).isEqualTo(bicycle2.hashCode()); // hashCode is auto-generated
        assertThat(bicycle1.toString()).isEqualTo(bicycle2.toString()); // toString is auto-generated

        // accessors are auto-generated:
        assertThat(bicycle1.color()).isEqualTo(bicycle2.color());
        assertThat(bicycle1.wheelSize()).isEqualTo(bicycle2.wheelSize());
    }

    @Test
    void should_write_and_read_text_directly_with_Files() throws Exception {
        Path filePath = Files.writeString(Files.createTempFile("demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        assertThat(fileContent).isEqualTo("Sample text");
    }

    @Test
    void test_string_stripIndent() {
        String s = """
                   public class MyObject {
                       public String toString() {
                           return "MyObject";
                       }
                   }
                   """;
        System.out.println("-" + s.stripIndent() + "-");
    }

    @Test
    void test_lambda_features() {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        var withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        assertThat(withoutBlanks).containsExactly("Java", "Kotlin");

        List<String> sampleList2 = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList2.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        assertThat(resultString).isEqualTo("JAVA, KOTLIN");
    }
}