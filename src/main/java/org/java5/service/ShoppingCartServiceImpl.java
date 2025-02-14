package org.java5.service;

import org.java5.DB;
import org.java5.entities.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> cart = new HashMap<>();

    /**
     * Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
     *
     * @param id là mã mặt hàng cần thêm
     * @return mặt hàng đã được thêm vào hoặc cập nhật số lượng
     */
    @Override
    public Item add(Integer id) {
        if (cart.containsKey(id)) {
            cart.get(id).setQty(cart.get(id).getQty() + 1);
            return cart.get(id);
        }
        Item item = DB.items.get(id);
        item.setQty(1);
        System.out.println(item.getName());
        cart.put(id, item);
        return item;
    }

    /**
     * Xóa mặt hàng khỏi giỏ
     *
     * @param id mã mặt hàng cần xóa
     */
    @Override
    public void remove(Integer id) {
        cart.remove(id);
    }

    /**
     * Thay đổi số lượng lên của mặt hàng trong giỏ
     *
     * @param id  mã mặt hàng
     * @param qty số lượng mới
     * @return mặt hàng đã được thay đổi số lượng
     */
    @Override
    public Item update(Integer id, int qty) {
        cart.get(id).setQty(qty);
        return cart.get(id);
    }

    /**
     * Xóa sạch các mặt hàng trong giỏ
     */
    @Override
    public void clear() {
        cart.clear();
    }

    /**
     * Lấy tất cả các mặt hàng trong giỏ
     */
    @Override
    public Collection<Item> getItems() {
        return cart.values();
    }

    /**
     * Lấy tổng số lượng các mặt hàng trong giỏ
     */
    @Override
    public int getCount() {
        return cart.size();
    }

    /**
     * Lấy tổng số tiền tất cả các mặt hàng trong giỏ
     */
    @Override
    public double getAmount() {
        return cart.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}
