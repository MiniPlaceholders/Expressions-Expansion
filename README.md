# Expressions-Expansion
Expressions Expansion for MiniPlaceholders.

Placeholders:
- `<expr_add:n1:n2:...:nX>` - Addition (`5`, `2` -> `7`)
- `<expr_sub:n1:n2>` - Subtraction (`5`, `2` -> `3`)
- `<expr_mul:n1:n2:...:nX>` - Multiplication (`5`, `2` -> `10`)
- `<expr_div:n1:n2>` - Division (`10`, `5` -> `2`)
- `<expr_mod:n1:n2>` - Division remainder (`5`, `2` -> `1`)
- `<expr_neg:n>` - Negation (`5` -> `-5`, `-5` -> `5`)
- `<expr_floor:n>` - Round down to integer (`5.05` -> `5`, `2.9` -> `2`)
- `<expr_round:n>` - Round to nearest integer (`5.05` -> `5`, `2.9` -> `3`)
- `<expr_ceil:n>` - Round up to integer (`5.05` -> `6`, `2.9` -> `3`)
- `<expr_min:n1:n2:...:nX>` - Get the lowest-valued number (`5`, `2` -> `2`)
- `<expr_max:n1:n2:...:nX>` - Get the highest-valued number (`5`, `2` -> `5`)
- `<expr_random>` - A random number from 0 to 1 (`0.15`). Acts like `<expr_random:0:1:0.01>`
- `<expr_random:min:max>` - A random integer from `min` to `max` (`50`, `100` -> `62`). Acts like `<expr_random:min:max:1>`
- `<expr_random:min:max:step>` - A random number from `min` to `max` with a step of `step` (`50`, `100`, `0.25` -> `68.75`)
- `<expr_concat:s1:s2:...:sN>` - Concat strings (`hello`, `world` -> `helloworld`)
- `<expr_substring:s:n1:n2>` - Create a substring of `s` from `n1` to `n2` character (`hello`, `2`, `4` -> `ll`)
- `<expr_length:s>` - Get length of the string (`hello` -> `5`)
- `<expr_format:format:arg1:arg2:...:argX>` - Format a string using [Java String.format()](https://www.javatpoint.com/java-string-format). It may be useful for [user expressions](#User-expressions)
- `<expr_if:o1:o2:r1:r2>` - Displays `r1` if `o1` and `o2` are same. Otherwise displays `rs`.
- `<expr_user:name:arg1:arg2:...:argX>` - Expand to a [User expression](#User-expressions)

# User expressions
You can create your own expression shortcut in config.yml using our Expression Expansion Language (EEL):

`add_and_multiply: "<expr_add:'<arg1>':'<expr_mul:\\'<arg2>\\':\\'<arg3>\\'>'>"` - The same as `arg1 + (arg2 * arg3)`. So, `<expr_user_add_and_multiply:2:3:4>` expands to `<expr_add:2:'<expr_mul:3:4>'>`, which evaluates to `2 + (3 * 4) = 14`

### Example user expressions
- `<expr_user:remove_first:s:n>` - Remove `n` first characters from `s` (`hello`, `2` -> `llo`), EEL: `  remove_first: "<expr_substring:'<arg1>':'<arg2>':'<expr_length:\\'<arg1>\\'>'>"`
- `<expr_user:remove_last:s:n>` - Remove `n` last characters from `s` (`hello`, `2` -> `hel`), EEL: `remove_last: "<expr_substring:'<arg1>':0:'<expr_sub:\\'<expr_length:\\\\\\'<arg1>\\\\\\'>\\':\\'<arg2>\\'>'>"`
- `<expr_user:decimals:n:decimals>` - format a number (`1.234567`, `2` -> `1.23`), EEL: `decimals: "<expr_format:'<expr_concat:\\'%.0\\':\\'<arg2>\\':\\'f\\'>':'<arg1>'>"`
- `<expr_user:pad_integer:n:length>` - pad an integer with zeros (`12`, `3` -> `012`), EEL: `pad_integer: "<expr_format:'<expr_concat:\\'%0\\':\\'<arg1>\\':\\'d\\'>':'<arg2>'>"`

# Nesting
Expressions can be nested. Try `/miniplaceholders parse me "<expr_add:1:'<expr_add:1:\\'<expr_add:1:\\\\\\'<expr_add:1:\\\\\\\\\\\\\\'<expr_add:1:0>\\\\\\\\\\\\\\'>\\\\\\'>\\'>'>"`
