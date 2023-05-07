# Expressions-Expansion
Expressions Expansion for MiniPlaceholders.

## Placeholders
### Basic Operations
- **Addition** | `<expr_add:n1:n2:...:nX>`
  - `<expr_add:5:2:3>` == 10
- **Subtraction** | `<expr_sub:n1:n2>`
  - `<expr_sub:10:3>` == 7
- **Multiplication** | `<expr_mul:n1:n2:...:nX>`
  - `<expr_mul:5:2:3:6>` == 180
- **Division** | `<expr_div:n1:n2>` 
  - `<expr_div:10:5>` == 2
- **Division remainder** `<expr_mod:n1:n2>`
  - `<expr_mod:5:2>` == 1
- **Negation** | `<expr_neg:n>`
  - `<expr_neg:5>` == -5
  - `<expr_neg:-5>` == 5
### Round
- **Round down to integer** | `<expr_floor:n>`
  - `<expr_floor:5.05>` == 5
  - `<expr_floor:2.9>` == 2
- **Round to nearest integer** | `<expr_round:n>` 
  - `<expr_floor:5.05>` == 5
  - `<expr_floor:2.9>` == 3
- **Round up to integer** | `<expr_ceil:n>`
  - `<expr_floor:5.05>` == 6
  - `<expr_floor:2.9>` == 3
- **Get the lowest-valued number** | `<expr_min:n1:n2:...:nX>` 
  - `<expr_min:5:10:15:2:500:9:69>` == 2
- **Get the highest-valued number** | `<expr_max:n1:n2:...:nX>`
  - `<expr_max:5:10:15:2:500:9:69>` ==  500
- **A random number from 0 to 1** | `<expr_random>` | Acts like `<expr_random:0:1:0.01>`
  - `<expr_random>` == 0.15
- **A random integer from `min` to `max`** | `<expr_random:min:max>` | Acts like `<expr_random:min:max:1>`
  - `<expr_random:1:100>` == 69
- **A random number from `min` to `max` with a step of `step`** | `<expr_random:min:max:step>`
  - `<expr_random:50:10:0.25>` == 68.75

### String Operations
- **Concat strings** | `<expr_concat:s1:s2:...:sN>`
  - `<expr_concat:hello:_:world>` == "hello_world"
- **Create a substring of `s` from `n1` to `n2` character** | `<expr_substring:s:n1:n2>`
  - `<expr_substring:hello:2:4>` == "ll"
- **Get length of the string** | `<expr_length:s>`
  - `<expr_length:hello>` == 5
- **Format a string using [Java String.format()](https://www.javatpoint.com/java-string-format)** | `<expr_format:format:arg1:arg2:...:argX>`
 | *It may be useful for [user expressions](#User-expressions)*
  - `<expr_format:'%s is not a %s':4drian3d:fruit>` == "4drian3d is not a fruit"
- **Displays `r1` if `o1` and `o2` are same. Otherwise, displays `rs`** | `<expr_if:o1:o2:r1:r2>`
  - `<expr_if:1:2:Equals:NotEquals>` == "NotEquals"
- **Sets `text` placeholders for a player with `uuid`.** | `<expr_player:uuid:text>`
  - `<expr_player:4drian3dUUID:<player_name>>` == 4drian3d
- **Sets `text` placeholders for a player with `name`.** | `<expr_player:name:text>`
  - `<expr_player:4drian3d:<player_ping>>` == 42
- **Expand to a [User expression](#User-expressions)** | `<expr_user:name:arg1:arg2:...:argX>`

## User expressions
You can create your own expression shortcut in config.yml using our Expression Expansion Language (EEL):

`add_and_multiply: "<expr_add:'<arg1>':'<expr_mul:\\'<arg2>\\':\\'<arg3>\\'>'>"` means `<expr_user:add_and_multiply:arg1:arg2:arg3>` will be evaluated to `arg1 + (arg2 * arg3)`. So, `<expr_user:add_and_multiply:2:3:4>` evaluates to `<expr_add:2:'<expr_mul:3:4>'>`, which is `2 + (3 * 4) = 14`

### Example user expressions
- `<expr_user:remove_first:s:n>` - Remove `n` first characters from `s` (`hello`, `2` -> `llo`), EEL: `  remove_first: "<expr_substring:'<arg1>':'<arg2>':'<expr_length:\\'<arg1>\\'>'>"`
- `<expr_user:remove_last:s:n>` - Remove `n` last characters from `s` (`hello`, `2` -> `hel`), EEL: `remove_last: "<expr_substring:'<arg1>':0:'<expr_sub:\\'<expr_length:\\\\\\'<arg1>\\\\\\'>\\':\\'<arg2>\\'>'>"`
- `<expr_user:decimals:n:decimals>` - format a number (`1.234567`, `2` -> `1.23`), EEL: `decimals: "<expr_format:'<expr_concat:\\'%.0\\':\\'<arg2>\\':\\'f\\'>':'<arg1>'>"`
- `<expr_user:pad_integer:n:length>` - pad an integer with zeros (`12`, `3` -> `012`), EEL: `pad_integer: "<expr_format:'<expr_concat:\\'%0\\':\\'<arg1>\\':\\'d\\'>':'<arg2>'>"`

## Nesting
Expressions can be nested. Try `/miniplaceholders parse me "<expr_add:1:'<expr_add:1:\\'<expr_add:1:\\\\\\'<expr_add:1:\\\\\\\\\\\\\\'<expr_add:1:0>\\\\\\\\\\\\\\'>\\\\\\'>\\'>'>"`

## Downloads
[![](https://raw.githubusercontent.com/Prospector/badges/master/modrinth-badge-72h-padded.png)](https://modrinth.com/plugin/expressions-expansion)