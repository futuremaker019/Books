package sia.demo.domain;

import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
@ToString
public class Ingredient {

    private final String id;
    private final String name;
    private final IngredientType type;


}
