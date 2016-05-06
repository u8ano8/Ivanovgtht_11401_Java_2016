package mvc.common;

import java.util.Map;

public class CartInfo{

    /**
     * key - id товара, value - кол-во товара
     */
    private Map<Long, Integer> goods;

    public Map<Long, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Integer> goods) {
        this.goods = goods;
    }

    /**
     * Получаем кол-во товара в корзине
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     * @return кол-во товара в корзине
     */
    public Integer getCount(Long goodId) {
        if (goods == null || goodId == null)
            return null;
        return goods.get(goodId);
    }

    /**
     * Есть ли в корзине товар с этим id
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     */
    public boolean containsGoodId(Long goodId){
        boolean res = false;
        if (goods == null || goodId == null)
            return res;
        return goods.containsKey(goodId);
    }
}
