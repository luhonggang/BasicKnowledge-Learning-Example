package com.study.stream;

import com.study.enums.DataTypeEnum;
import com.study.enums.RefVariableTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/4/17 14:03
 */
public class MapUseStream {
    public static void main(String[] args) {

//        Map<String,String> variableMap = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            variableMap.put("e-data-" + i,"string");
//            if(i > 6){
//                variableMap.put("e-data-" + i,"varchar00 " + i);
//            }
//        }
//        List<MentionSource> mentionSourcesDTOList = variableMap.entrySet().stream()
//                .map(entry -> {
//                    String key = entry.getKey().trim();
//                    String value = entry.getValue().trim();
//                    return MentionSource.builder()
//                            .key("e." + key)
//                            .value("e." + key)
//                            .name(key)
//                            .dataType(("string".equals(value) || value.startsWith("varchar") ? 1 : 2))
//                            .refType(3)
//                            .build();
//                }).collect(Collectors.toList());
//
//        mentionSourcesDTOList.forEach(System.out::println);
//
//
//        List<MentionSource> mentionSourcesList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//
//        }
//        mentionSourcesList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
//                new TreeSet<>(Comparator.comparing(MentionSource::toString))), ArrayList::new));
//
//        System.out.println(" +++++++++++ 开始打印toMap ++++++++++ ");
//        toMap();
//
//        System.out.println(" +++++++++++ 开始打印map ++++++++++++");
//        testMap();

        System.out.println(" +++++++++++ 开始测试joining方法 ++++++++++++ ");
        testCollectors();
    }


    /**
     * toMap() 方法调用测试
     */
    public static void toMap(){
        List<StrategyVariableVO> strategyVariableList = new ArrayList<>(16);
        for (int i = 0; i < 10 ; i++) {
            StrategyVariableVO vo = new StrategyVariableVO();
            vo.setId(Long.valueOf(i));
            vo.setName("xntest00" + i);
            vo.setDefaultValue("10"+i);
            strategyVariableList.add(vo);

        }
        Map<String, Object> vm = strategyVariableList.parallelStream()
                .collect(Collectors.toMap(strategyVariable -> RefVariableTypeEnum.STRATEGY_VARIABLE.getRef() + strategyVariable.getName(),
                        var -> DataTypeEnum.NUMERICAL.matches(var.getDataType()) ?
                                (StringUtils.isNotBlank(var.getDefaultValue()) ? BigDecimal.valueOf(Float.valueOf(var.getDefaultValue())) : BigDecimal.ZERO) :
                                var.getDefaultValue()));


        Set<String> keys = vm.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(" key : "+ key +" value : " + vm.get(key));
        }
    }

    /**
     * map 方法测试
     */
    public static void  testMap(){
        List<StrategyVariableVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StrategyVariableVO vo = new StrategyVariableVO();
            vo.setId(Long.valueOf(i));
            vo.setDefaultValue("100 " + i);
            list.add(vo);
        }
            list = list.parallelStream()
                    .map(s -> {
                         s.setName(s.getDefaultValue() + " map ");
                        return s;
                    })
                    .sorted(Comparator.comparing(StrategyVariableVO::getId))
                    .collect(Collectors.toList());


        list.stream().forEach(System.out::println);
    }

    /**
     * Collectors join 方法测试
     */
    public static void testCollectors(){
        List<StrategyVariableVO> list = new ArrayList<>(12);
        for (int i = 0; i < 10; i++) {
            StrategyVariableVO vo = new StrategyVariableVO();
            vo.setName("name " + i);
            vo.setId(Long.valueOf(i));
            vo.setDefaultValue(i+"");
            list.add(vo);
        }

        list.stream().map(StrategyVariableVO::getName).collect(Collectors.joining(","));

        list.stream().forEach(System.out::println);

        int size = list.size();
        StrategyVariableVO vo = list.stream()
                .filter(f -> f.getDefaultValue().equalsIgnoreCase("90"))
                .findFirst()
                .orElseGet(() -> list.get(size - 1));
        System.out.println(" vo 过滤后的list是 : name 1 ? : " + vo.toString());
    }

}
