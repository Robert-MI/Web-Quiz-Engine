package engine;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswer {
    private List<Integer> answer;
}
