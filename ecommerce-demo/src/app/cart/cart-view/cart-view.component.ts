import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Product } from 'src/app/models/product';
@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css'],
})
export class CartViewComponent implements OnInit {
  cartItem: Product[] = [];
  totalPrice: number = 0;
  constructor(private cartService: CartService) {}
  ngOnInit(): void {
    this.cartService.getCartItem().subscribe((data) => {
      this.cartItem = data;
      this.totalPrice = this.calTotalPrice();
    });
  }
  calTotalPrice(): number {
    let total = 0;
    this.cartItem.forEach((item) => {
      total += item.price;
    });
    return total;
  }
  clearCart() {
    this.cartService.clearCart().subscribe();
  }
}
