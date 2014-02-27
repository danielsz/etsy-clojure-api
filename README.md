# Etsy API library for Clojure

Initial release of an API wrapper for Etsy in Clojure.

## Installation

Add the following dependency to your project.clj file:

    [etsy "0.0.2"]

## Usage

Before issuing actual API calls, you need to provide your API key and secret.
(You must have received them when registering your Etsy application.)

    (require '[etsy.core :refer [make-consumer])

```clojure
(make-consumer "consumer-key" "consumer-secret")
```

Now you're ready to issue API calls.

```clojure
(etsy.api.shop/get-shop "shop-id")
```

The call above will result in an unauthenticated request.

To issue an authenticated request on behalf of a user, wrap the request with the user's OAuth token and secret.

```clojure
(with-auth "oauth-token" "oauth-secret"
   (etsy.api.shop/get-shop "shop-id"))
```

The JSON results are converted to a native Clojure map.

## Design philosophy

Following the principle of least astonishment (POLA), the design of the library follows a one-on-one mapping with the official Etsy API.

Every category in the API corresponds to a namespace. Every API call corresponds to a function whose name has been converted from CamelCase to hyphenated strings. Every function accepts arguments modeled on the API options.

Please refer to the official reference: http://www.etsy.com/developers/documentation/


## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
