package co.codingnomads.kraken;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.request.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import co.codingnomads.kraken.util.RateLimitThreadTest;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{


        KrakenExchange exchange = new KrakenExchange(
                "Insert API-Key",
                "Insert API-Secret",
                4);

        GenericRequestHandler handler = new GenericRequestHandler();

        RequestBodyGeneric a = new GetTradeBalanceRequestBody(null, "ZEUR");

        OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null, exchange.getApiAuthentication());
        OutputWrapper serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null, exchange.getApiAuthentication());
//        OutputWrapper recentTrades = handler.callAPI(KrakenRequestEnum.GETRECENTTRADES, null);
//        OutputWrapper tradableAssetPairs = handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS, null);
//        OutputWrapper openPositions = handler.callAPI(KrakenRequestEnum.GETOPENPOSITIONS, null);


        //ricky currnetly working gettickerinfo and getrecenttrades


//        ObjectMapper mapper = new ObjectMapper();
        //get results from OutputWrapper "orderBook"
        //Map<String, GetOrderBookOutput> results = (Map<String, GetOrderBookOutput>) orderBook.getResult();
        //If there are any errors, they will be in orderBook.getErrors()
        //String[] errors = orderBook.getError();

        //test for recentTrades
//        Map<String, GetRecentTradesOutput> recentTradesResult = (Map<String, GetRecentTradesOutput>) recentTrades.getResult();
//        String[] recentTradesError = recentTrades.getError();

        //test for tradableAssetPairs
//        Map<String, GetTradableAssetPairsOutput> tradeableAssetPairsResult = (Map<String, GetTradableAssetPairsOutput>) tradableAssetPairs.getResult();
//        String[] tradableAssetPairsError = tradableAssetPairs.getError();

        //test for openpositions
//        Map<String, GetOpenPositionsOutput> openPositionsResult = (Map<String, GetOpenPositionsOutput>) openPositions.getResult();
//        String[] openPositionError = openPositions.getError();


        //Another exmaple:
//        KrakenServerTime time = (KrakenServerTime) serverTime.getResult();
//        String[] serverTimeErrors = serverTime.getError();

//        Map<String, CancelOpenOrderOutput> results2 = (Map<String, CancelOpenOrderOutput>) cancelOrder.getResult();
//        String[] cancelOrderErrors = cancelOrder.getError();





    }


    public static void testRateLimit(ApiKey key) {

        System.out.println("Testing rate limit");

        for(int i =0; i < 20; i++){

            RateLimitThreadTest threadOne = new RateLimitThreadTest("thread" + i, key);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("All done");

    }

}
