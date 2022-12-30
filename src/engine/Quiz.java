package engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String text;
    @NotNull
    @Size(min = 2)
    @ElementCollection
    private List<String> options;
    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    public boolean getAnswer(List<Integer> ans){
        if (ans.size() == 0 && answer.size() == 0) {
            return true;
        }else if(!ans.isEmpty()) {
            if(ans.size() == 1 && answer.size() == 1) {
                return answer.contains(ans.get(0));
            }
            else {
                Collections.sort(answer);
                Collections.sort(ans);
                return ans.equals(answer);
            }
        } else {
            return false;
        }
    }
}
