package dynamic;

import java.util.List;

public class Rule {

    private List<Condition> conditions;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    // private Rule.eventType eventType;
/*
    public Rule.eventType getEventType() {
        return eventType;
    }

    public void setEventType(Rule.eventType eventType) {
        this.eventType = eventType;
    }
*/
    @Override
    public String toString(){
        StringBuilder statementBuilder = new StringBuilder();

        for (Condition condition : getConditions()) {

            String operator = null;

            switch (condition.getOperator()) {
                case EQUAL_TO:
                    operator = "==";
                    break;
                case NOT_EQUAL_TO:
                    operator = "!=";
                    break;
                case GREATER_THAN:
                    operator = ">";
                    break;
                case LESS_THAN:
                    operator = "<";
                    break;
                case GREATER_THAN_OR_EQUAL_TO:
                    operator = ">=";
                    break;
                case LESS_THAN_OR_EQUAL_TO:
                    operator = "<=";
                    break;
            }

            statementBuilder.append(condition.getField()).append(" ").append(operator).append(" ");

            if (condition.getValue() instanceof String) {
                statementBuilder.append("'").append(condition.getValue()).append("'");
            } else {
                statementBuilder.append(condition.getValue());
            }

            statementBuilder.append(" && ");
        }

        String statement = statementBuilder.toString();

        // remove trailing &&
        return statement.substring(0, statement.length() - 4);
    }

  /*  public static enum eventType {

        ORDER("ORDER"),
        INVOICE("INVOICE");
        private final String value;
        private eventType(String value) {
        	this.value = value;
        }*/

/*        private static Map<String, Rule.eventType> constants = new HashMap<String, Rule.eventType>();
        static {
            for (Rule.eventType c: values()) {
                constants.put(c.value, c);
            }
        }


        public static Rule.eventType fromValue(String value) {
            Rule.eventType constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }*/
    

}
