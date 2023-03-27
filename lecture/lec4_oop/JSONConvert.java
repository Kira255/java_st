package lecture.lec4_oop;

public class JSONConvert {

    public static <T> String convert(T o) {

        if (o instanceof Integer) {
            return String.format("%s", ((Integer) o).toString());
        }

        else if (o instanceof String) {
            if (o != null)
                return String.format("\"%s\"", o);
        }

        else if (o instanceof Cat) {
            return String.format(
                    "{\"name\": \"%s\", \"age\": \"%s\", \"color\": \"%s\", \"weight\": \"%s\", \"height\": \"%s\"}",
                    ((Cat) o).getName(), ((Cat) o).getAge(), ((Cat) o).getColor(), ((Cat) o).getWeight(),
                    ((Cat) o).getHeight());
        }
        return null;
    }
}
