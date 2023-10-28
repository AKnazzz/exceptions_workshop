package task_2;

import task_2.exceptions.NotEnoughMaterialException;
import task_2.exceptions.NotEnoughWoodException;

public class Wand {
    private String woodType; // тип дерева палочки
    private int length; //длина палочки в дюймах
    private String coreMaterial; // материал сердца палочки
    private int powerLevel; // уровень магической мощи палочки

    public Wand(String woodType, int length, String coreMaterial, int powerLevel) throws NotEnoughWoodException,
            NotEnoughMaterialException {

        if (woodType == null || woodType.isBlank()) {
            throw new NotEnoughWoodException("Значение woodType должно быть заполнено.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Значение length должно быть больше 0.");
        }
        if (coreMaterial == null || coreMaterial.isBlank()) {
            throw new NotEnoughMaterialException("Значение coreMaterial должно быть заполнено.");
        }
        if (powerLevel <= 0) {
            throw new IllegalArgumentException("Значение powerLevel должно быть больше 0.");
        }


        this.woodType = woodType;
        this.length = length;
        this.coreMaterial = coreMaterial;
        this.powerLevel = powerLevel;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCoreMaterial() {
        return coreMaterial;
    }

    public void setCoreMaterial(String coreMaterial) {
        this.coreMaterial = coreMaterial;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
}
