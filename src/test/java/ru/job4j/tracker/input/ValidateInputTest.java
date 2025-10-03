package ru.job4j.tracker.input;

import ru.job4j.tracker.output.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"2", "3", "4", "5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-6"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-6);
    }
}