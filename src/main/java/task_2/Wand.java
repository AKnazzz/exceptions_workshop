package task_2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;

@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class Wand {
    private String woodType; // тип дерева палочки
    private int length; //длина палочки в дюймах
    private String coreMaterial; // материал сердца палочки
    private int powerLevel; // уровень магической мощи палочки

    public Wand(String woodType, int length, String coreMaterial, int powerLevel) throws NotEnoughWoodException,
            NotEnoughMaterialException {

        if (woodType == null || woodType.isBlank()) {
            throw new NotEnoughWoodException("The woodType value must be filled in.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("The length value must be greater than 0.");
        }
        if (coreMaterial == null || coreMaterial.isBlank()) {
            throw new NotEnoughMaterialException("The coreMaterial value must be filled in.");
        }
        if (powerLevel <= 0) {
            throw new IllegalArgumentException("The powerLevel value must be greater than 0.");
        }


        this.woodType = woodType;
        this.length = length;
        this.coreMaterial = coreMaterial;
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "Wood: " + woodType + ", " + length + " in. , core: " + coreMaterial + ", power: " + powerLevel;
    }

}
