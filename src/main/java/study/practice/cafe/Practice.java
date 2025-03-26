package study.practice.cafe;

import lombok.ToString;

@ToString
public class Practice {
    private String defaultValue;
    private String name;
    private String description;

    public Practice(String defaultValue, String name, String description) {
        this.defaultValue = defaultValue;
        this.name = name;
        this.description = description;
    }

    public static PracticeBuilder builder(){
        return new PracticeBuilder();
    }

    public static class PracticeBuilder{
        private String defaultValue;
        private String name;
        private String description;

        public PracticeBuilder defaultValue(String defaultValue){
            this.defaultValue = defaultValue;
            return this;
        }

        public PracticeBuilder name(String name){
            this.name = name;
            return this;
        }

        public PracticeBuilder description(String description){
            this.description = description;
            return this;
        }

        public Practice build(){
            return new Practice(defaultValue, name, description);
        }

    }

}
