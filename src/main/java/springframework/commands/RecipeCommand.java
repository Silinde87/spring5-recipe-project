package springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springframework.domain.Category;
import springframework.domain.Difficulty;
import springframework.domain.Ingredient;
import springframework.domain.Notes;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private NotesCommand notes;
    private Difficulty difficulty;
    private Set<CategoryCommand> categories = new HashSet<>();
}