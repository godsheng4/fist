package autoArithmetic;
import java.util.Random;

public class CreateInteger {

    private static final String[]  OPERATOR = {"+", "-", "*", "÷"};

    /**
     * 整数生成器
     * @param range
     */
    public static String createProblem(){
        Random random = new Random();
        int range = 100;
        int operatorCount = 1 + random.nextInt(3); //随机操作符的个数（1-3个）
        int operand[] = new int[operatorCount + 1]; //操作数个数
        int[] operatorIndex = index(operatorCount, 4, random);

        for(int i = 0; i < operatorCount + 1; i++){
            operand[i] = random.nextInt(range);
        }

        String formula = stitchingFormula(operatorCount, operand, operatorIndex,0);

        //计算结果
        Calculator calculator = new Calculator();
        int res = calculator.algorithm(formula);

        if (res > 0){
        	  return formula;
        }else {
            return createProblem();
        }
      
    }



    /**
     * 随机产生操作符的下标数组
     * @param operatorCount
     * @param operatorTotal
     * @param random
     * @return
     */
    public static int[] index(int operatorCount,int operatorTotal, Random random){
        int similar = 0;
        int[] operatorIndex = new int[operatorCount];
        for(int i = 0; i < operatorCount; i++){
            operatorIndex[i] = random.nextInt(operatorTotal);
        }

        for (int i : operatorIndex) {
            if(operatorIndex[0] == i) {
                similar++;
            }
        }
        if(similar == operatorCount && operatorCount != 1){
            return index(operatorCount, operatorTotal, random); //保证一个式子里至少有2个不同的操作符，若所有操作符下标都一样，则重新产生操作符下标
        } else {
            return operatorIndex;
        }
    }

    /**
     * 拼接式子
     * @param operatorCount
     * @param operand
     * @param operatorIndex
     * @return
     */
    public static String stitchingFormula(int operatorCount, int operand[], int[] operatorIndex,int bracketForm){
        StringBuilder formula = new StringBuilder();
        switch (operatorCount){
            case 1:
                // 1+2型
                formula.append(operand[0])
                        .append(" ")
                        .append(OPERATOR[operatorIndex[0]])
                        .append(" ")
                        .append(operand[1])
                        .append(" ")
                        .append("=");
                break;
            case 2:{
                // 1+2+3 型
                if (bracketForm == 0){
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append("=");

                }else {
                    //1+(2+3)型
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append("(")
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                }break;
            }
            case 3:{
                if (bracketForm == 0){
                    //1+((2+3)-4)型
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append("((")
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append(OPERATOR[operatorIndex[2]])
                            .append(" ")
                            .append(operand[3])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                }else {
                    //(1+2)+(3+4)型
                    formula.append("(")
                            .append(" ")
                            .append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append("(")
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[2]])
                            .append(" ")
                            .append(operand[3])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                }break;
            }
        }
        return formula.toString();
    }
}