package xaircraft.androidtest.rxjava;


import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by chenyulong on 16/6/29.
 */
public class RxjavaTest {
    private static final String TAG = "RxjavaTest :";
    public static void main(String args[]){
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                System.out.println("txTest onStart");
                super.onStart();
            }

            @Override
            public void onCompleted() {
                System.out.println("txTest onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("txTest onError!");

            }

            @Override
            public void onNext(String s) {
                System.out.println("txTest onNext!");
                System.out.println("txTest:" + s);
            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hi");
                subscriber.onNext("hey");
                subscriber.onNext("hello");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(subscriber);

//        Observable<String> observable1 = Observable.just("hey", "hi", "hello");
//        observable1.subscribe(subscriber);
//
//        Action0 onCompleteAction = new Action0() {
//            @Override
//            public void call() {
//
//            }
//        };
//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        };
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//
//            }
//        };
//
//        observable.subscribe(onNextAction, onErrorAction, onCompleteAction);
//

//        String[] names = {"1", "2", "3", "4", "5"};
//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println(TAG + s);
//                    }
//                });

        Observable<String> myObservable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onNext("4");
                subscriber.onNext("5");
                subscriber.onCompleted();
            }
        });
        Observer<String> myObserver1 = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);

            }
        };
        myObservable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver1);
    }
}
