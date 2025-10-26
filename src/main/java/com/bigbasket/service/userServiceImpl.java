package com.bigbasket.service;


import com.bigbasket.entity.OrderItem;
import com.bigbasket.entity.User;
import com.bigbasket.exception.NotFoundException;
import com.bigbasket.repository.OrderItemRepository;
import com.bigbasket.repository.OrderRepository;
import com.bigbasket.repository.ProductRepository;
import com.bigbasket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public User addUser(User user) {
        if(user == null)throw  new NotFoundException("Please check input");
        return userRepository.save(user) ;
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) { //isPresent return true or false
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateEmailById(Integer userId, String newEmail) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setEmail(newEmail);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<OrderItem> getOrders(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No user found by user id "+userId));
        List<OrderItem> orderItems = orderItemRepository.findAllByUserId(userId);
        return orderItems;
    }


//    @Override
//    public Orders addOrder(int userId, Orders order) {
//        if(order == null)throw  new NotFoundException("Please check input");
//        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User doesnot exists with userId "+userId));
//        List<Product> pL = productRepository.findByStatus(Status.INSTOCK);
//        if (pL.isEmpty())
//            throw new NotFoundException("No product available");
//        Product product = pL.get(0);
//        order.setUser(user);
//        user.getOrdersList().add(order);
//        product.setOrders(order);
//        return orderRepository.save(order);
//    }

//    @Override
//    public Orders addProductInOrder(int orderId, int productId) {
//        Orders orders = orderRepository.findById(orderId).orElseThrow(()->new NotFoundException("No order exists with order id "+orderId));
//        Product product = productRepository.findById(productId).orElseThrow(()->new NotFoundException("No product exists with product id "+ productid));
//        orders.getProductList().add(product);
//        product.setOrders(orders);
//        return orderRepository.save(orders);
//    }

//    @Override
//    public Orders updateOrder(Orders order) {
//        Orders o1 = orderRepository.findById(order.getOrderId()).orElseThrow(()->new NotFoundException("No order exists with order id "+order.getOrderId()));
//        o1.setDeliveryDate(order.getDeliveryDate());
//        o1.setNoOfProducts(order.getProductList().size());
//        o1.setProductList(order.getProductList());
//        return orderRepository.save(o1);
//    }

    // @Override
    // public List<Orders> orderHistory(int userId) throws NotFoundException {
    //     User user = userRepository.findById(userId).orElseThrow(()->new NotFoundException("No user exists with user id "+userId));
    //     PageRequest pageable = PageRequest.of(0,5);
    //     return orderRepository.findByUser(user,pageable).getContent();
    // }

    // @Override
    // public List<Product> productSuggestion(int userId) throws NotFoundException {
    //     User user = userRepository.findById(userId).orElseThrow(()->new NotFoundException("No user exists with user id "+userId));
    //     List<String> list = productRepository.getCategoryName(user);
    //     List<Product> products = new ArrayList<>();
    //     for(String s : list){
    //         List<Product> p1 = productRepository.getProductByCategoryName();
    //         if(!p1.isEmpty()){
    //             products.addAll(p1);
    //         }
    //     }
    //     return products;
    // }
}
