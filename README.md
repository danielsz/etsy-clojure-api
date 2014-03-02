# Etsy API library for Clojure

Initial release of an API wrapper for Etsy in Clojure.

## Installation

Add the following dependency to your project.clj file:

    [etsy "0.0.2"]

## Usage

Before issuing actual API calls, you need to provide your API key and secret.
(You must have received them when registering your Etsy application). 

```clojure
(require '[etsy.core :refer [make-consumer])
(make-consumer "consumer-key" "consumer-secret")
```

Now you're ready to issue API calls.

```clojure
(etsy.api.shop/get-shop "shop-id")
```

The above call will result in an unauthenticated request.

To issue an authenticated request on behalf of a user, wrap the request with the user's OAuth token and secret.

```clojure
(require '[etsy.core :refer [with-auth])
(with-auth "oauth-token" "oauth-secret"
   (etsy.api.shop/get-shop "shop-id"))
```

The JSON results returned by Etsy will be converted into a native Clojure map.

## Design philosophy

Following the principle of least astonishment (POLA), the design of the library follows a one-to-one mapping with the official Etsy API.

Every category in the API (Shop, Listing, Order, etc.) corresponds to a namespace. Every API call (getShop, findAllShops, findAllUserShops, etc.) corresponds to a function whose name has been converted from CamelCase to hyphenated strings. Every function accepts arguments modeled on the API specification.

When in doubt, please refer to the official reference: http://www.etsy.com/developers/documentation/

### Vision

Library maintenance for a third-party API is burdensome, and can be completely eliminated if the API can provide a description of itself. Based on the document specification, the library would dynamically generate the required functions in their respective namespaces. Ian Barber showed how to achieve this with his [Clojure client](https://github.com/ianbarber/clj-gapi) for Google web service APIs. Fortunately, Etsy also provides a meta API call, corresponding in fact to the root endpoint ("/"). 

## Contribution

This library provides the machinery to issue public and private requests to Etsy, but currently implements very few actual API calls. You'll have to write them yourself, and submit a pull request. The process is easy, and you should be able to figure it out if you've understood the previous section (design philosophy).

If you feel up to the task, you are welcome to coordinate work on the dynamic generation logic.

A test suite is welcome too. 

## License

Distributed under the Eclipse Public License version 1.0.
