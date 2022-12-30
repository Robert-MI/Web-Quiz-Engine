package engine;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResult {
    private boolean success;
    private String feedback;
}
