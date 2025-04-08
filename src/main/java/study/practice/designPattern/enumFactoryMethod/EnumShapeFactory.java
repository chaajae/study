package study.practice.designPattern.enumFactoryMethod;

public enum EnumShapeFactory {
    RECTANGLE{
        public Shape createShape(){
            return new Rectangle();
        }
    },
    CIRCLE{
        public Shape createShape(){
            return new Circle();
        }
    };

    public Shape create(String color){
        Shape shape = createShape();
        shape.setColor(color);
        return shape;
    }

    abstract protected Shape createShape();
}
